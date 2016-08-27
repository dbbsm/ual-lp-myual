/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ual.myual.datamanager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import ual.myual.models.CV;
import ual.myual.models.Email;
import ual.myual.models.Pergunta;
import ual.myual.models.User;
import ual.myual.rowmapping.*;

/**
 *
 * @author Diogo
 */
public class CVDAO {
    
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
 
    public void setDataSource(DataSource dataSource) {
      this.dataSource = dataSource;
      this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    public int haveCV(int id){
    
        String sql ="Select count(users_id) from cvs where users_id="+id;
    
        Integer i = jdbcTemplate.queryForObject(sql, Integer.class);
        
        return i;
        
    }
    public CV getnewCV()
    {
        String sql = "SELECT * FROM perguntas_documentos where documento='cv'";
        
        CV cv = (CV) jdbcTemplate.queryForObject(sql, new NewCVRowMapper());
        
        return cv;
    }
    
    public CV getUserCV(int userid)
    {
        String sql ="SELECT id from cvs where users_id="+userid;
        
        int cvID = jdbcTemplate.queryForObject(sql, Integer.class);
        
        String sql1 = "SELECT p.id, p.nr_pergunta, p.pergunta, r.id, r.resposta from perguntas_documentos as p "
                + "join respostas_cvs as r where p.id=r.pergunta_id and cv_id="+cvID;
        
        CV cv = (CV) jdbcTemplate.queryForObject(sql1, new CVPerguntaRespostaRowMapper());
        
        return cv;
    }
    
    public void editCv(CV cv){
        
        for(Pergunta p : cv.getQuestionario())
        {

            String sql= "UPDATE respostas_cvs SET resposta = ? where id = "+p.getId_resposta();
                
            jdbcTemplate.update(sql,p.getResposta());
                       
            
        }        
    
    }
    
    public void saveNewcv(CV cv, User user){
    
        String sql1 = "INSERT INTO cvs(users_id) "
                + "VALUES(?)";
        
        
        KeyHolder keyHolder = new GeneratedKeyHolder();
        
        jdbcTemplate.update( new PreparedStatementCreator() {
        
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
            PreparedStatement ps =
                connection.prepareStatement(sql1, new String[] {"id"});
            ps.setInt(1, user.getId());
            return ps;
        }
        },
        keyHolder);
        
        
        long i = (long) keyHolder.getKey();
                
        int novoID = (int) (long) i;
        
        for(Pergunta p : cv.getQuestionario())
        {
           
            String sql2= "Insert into respostas_cvs(cv_id,pergunta_id,resposta) values (?,?,?)";
                
            jdbcTemplate.update(sql2, novoID,p.getId(),p.getResposta());
                       
            
        }
        
    
    }
    
    public Email getEmail(){
    
        
        String sql="Select email,password from email where estado='a'";
        
        Email email = (Email) jdbcTemplate.queryForObject(sql, new EmailRowMapper());
    
        return email;
    }
    
    
}
