/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ual.myual.rowmapping;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import ual.myual.models.AnexoB;
import ual.myual.models.HorasDeTrabalho;
import ual.myual.models.Pergunta;
import ual.myual.models.Pergunta10;

/**
 *
 * @author Diogo
 */
public class AnexoBPergunta10RowMapper implements RowMapper{
    
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        
        AnexoB anexo = new AnexoB();
        
        Pergunta10 p = new Pergunta10();
        
        
        p.setId(rs.getInt("id"));
        p.setNr_pergunta(rs.getString("nr_pergunta"));
        
        anexo.setPergunta10(p);
        
        
        HorasDeTrabalho h = new HorasDeTrabalho(rs.getInt("horas_contacto"), rs.getInt("horas_consolidacao"),
                rs.getInt("horas_outras_actividades"));
        
        anexo.getPergunta10().getNr_semana().add(rs.getInt("nr_semana"));
        anexo.getPergunta10().getNr_sessao().add(rs.getInt("nr_sessao"));
        anexo.getPergunta10().getConteudo_programatico().add(rs.getString("conteudo_programatico"));
        
        anexo.getPergunta10().getHoras_de_trabalho().add(h);
        
        anexo.getPergunta10().getDescricao_outras_actividades().add(rs.getString("descricao_outras_actividades"));
                
        while(rs.next())
        {
            anexo.getPergunta10().getNr_semana().add(rs.getInt("nr_semana"));
            anexo.getPergunta10().getNr_sessao().add(rs.getInt("nr_sessao"));
            anexo.getPergunta10().getConteudo_programatico().add(rs.getString("conteudo_programatico"));

            anexo.getPergunta10().getHoras_de_trabalho().add(new HorasDeTrabalho(rs.getInt("horas_contacto"), rs.getInt("horas_consolidacao"),
                rs.getInt("horas_outras_actividades")));

            anexo.getPergunta10().getDescricao_outras_actividades().add(rs.getString("descricao_outras_actividades"));
        }
                
        return anexo;
    }
    
}
