/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ual.myual.datamanager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import ual.myual.models.*;
import ual.myual.models.User;
import ual.myual.rowmapping.*;

/**
 *
 * @author Diogo
 */
public class AnexoDAO {
    
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
 
    public void setDataSource(DataSource dataSource) {
      this.dataSource = dataSource;
      this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    /*retorna a lista de cadeiras*/
    public ArrayList<UnidadeCurricular> getCadeiras()
    {
        String sql = "SELECT * FROM cadeiras";
        
        ArrayList<UnidadeCurricular> cadeiras = new ArrayList<UnidadeCurricular>();
        
        cadeiras = (ArrayList<UnidadeCurricular>) jdbcTemplate.query(sql, new CadeirasRowMapper());
        
        return cadeiras;
    }
    
    /*retorna um anexo novo*/
    public AnexoB getnewAnexo()
    {
        String sql = "SELECT * FROM perguntas_documentos where documento='anexoB'";
        
        AnexoB anexo = (AnexoB) jdbcTemplate.queryForObject(sql, new NewAnexoBRowMapper());
        
        return anexo;
    }
    
    /*retorna um anexo com o id correspondente*/
    public AnexoB getAnexo(int anexoId)
    {
        
        String sql = "SELECT p.id, p.nr_pergunta, p.pergunta, r.pergunta_id, r.resposta from perguntas_documentos as p "
                + "join respostas_anexos as r where p.id=r.pergunta_id and anexo_id="+anexoId;
        
        AnexoB anexo = (AnexoB) jdbcTemplate.queryForObject(sql, new AnexoBPerguntaRespostaRowMapper());
        
        String sql1 = "Select p.id, p.nr_pergunta, nr_semana, nr_sessao, conteudo_programatico, horas_contacto, "
                + "horas_consolidacao, horas_outras_actividades, descricao_outras_actividades "
                + "    from respostas_pergunta10 join perguntas_documentos as p where p.id=pergunta_id "
                + "and anexo_id="+anexoId;
        
        AnexoB anexotemp = (AnexoB) jdbcTemplate.queryForObject(sql1, new AnexoBPergunta10RowMapper());
        
        anexo.setPergunta10(anexotemp.getPergunta10());
        
        return anexo;
    }
    
    /*retorna todos os anexos de um user*/
    public ArrayList<AnexoForm> getAllAnexos(int userId)
    {
        
        
        String sql = "SELECT a.id, c.nome, a.ano, a.estado from anexos as a join cadeiras as c "
                + "where a.cadeiras_id=c.id and a.estado='r' and a.users_id="+userId;
        
        ArrayList<AnexoForm> anexos = new ArrayList<AnexoForm>();
        
        anexos = (ArrayList<AnexoForm>) jdbcTemplate.query(sql, new AnexoFormInfoRowMapper());
        
        return anexos;
    }
    
    /*funçao que faz o update do campo estado do anexo pedido para ficar a d - deleted*/
    public void setEstadoDeleted(int anexoid)
    {
        String sql = "UPDATE anexos SET estado = 'd' where id = ?";
        
        jdbcTemplate.update(sql,anexoid);

    }
    
    public int saveAnexo(User user, AnexoB anexo)
    {
        String sql ="SELECT * from cadeiras where nome='"+anexo.getAnexo().get(0).getResposta()+"'";
        
        UnidadeCurricular cadeira = (UnidadeCurricular) jdbcTemplate.queryForObject(sql, new CadeirasRowMapper());
        
        anexo.setCadeira(cadeira);
        
        String sql1 = "INSERT INTO anexos(users_id,cadeiras_id,ano, estado) "
                + "VALUES(?,?,now(),'r')";
        
        
        KeyHolder keyHolder = new GeneratedKeyHolder();
        
        jdbcTemplate.update( new PreparedStatementCreator() {
        
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
            PreparedStatement ps =
                connection.prepareStatement(sql1, new String[] {"id"});
            ps.setInt(1, user.getId());
            ps.setInt(2,cadeira.getId());
            return ps;
        }
        },
        keyHolder);
    
        System.out.println(keyHolder.getKey());
        
        long i = (long) keyHolder.getKey();
                
        int novoID = (int) (long) i;
        
        for(Pergunta p : anexo.getAnexo())
        {
            
            String sql2= "Insert into respostas_anexos(anexo_id,pergunta_id,resposta) values (?,?,?)";
                
            jdbcTemplate.update(sql2, novoID,p.getId(),p.getResposta());
            
            if(p.getId()==15)
            {
                if(!anexo.getPergunta10().getNr_semana().isEmpty())
                {
                    for(int x=0; x<anexo.getPergunta10().getNr_semana().size();x++)
                    {
                        String sql3="Insert into respostas_pergunta10(anexo_id,pergunta_id,nr_semana,"
                                + "nr_sessao,conteudo_programatico,horas_contacto,horas_consolidacao,"
                                + "horas_outras_actividades,descricao_outras_actividades) values "
                                + "(?,?,?,?,?,?,?,?,?)";

                        jdbcTemplate.update(sql3,novoID,p.getId(),anexo.getPergunta10().getNr_semana().get(x),
                                anexo.getPergunta10().getNr_sessao().get(x),anexo.getPergunta10().getConteudo_programatico().get(x),
                                anexo.getPergunta10().getHoras_de_trabalho().get(x).getHoras_contacto(),
                                anexo.getPergunta10().getHoras_de_trabalho().get(x).getHoras_consolidacao(),
                                anexo.getPergunta10().getHoras_de_trabalho().get(x).getHoras_outras_actividades(),
                                anexo.getPergunta10().getDescricao_outras_actividades().get(x));
                    }
                }
            }                      
            
        }
        return novoID;
        
    }
    
    public Email getEmail(){
    
        
        String sql="Select email,password from email where estado='a'";
        
        Email email = (Email) jdbcTemplate.queryForObject(sql, new EmailRowMapper());
    
        return email;
    }
    
}
