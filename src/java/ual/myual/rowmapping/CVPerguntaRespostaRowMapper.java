/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ual.myual.rowmapping;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import ual.myual.models.CV;
import ual.myual.models.Pergunta;

/**
 *
 * @author Diogo
 */
public class CVPerguntaRespostaRowMapper implements RowMapper{
    
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        
        CV cv = new CV();
        
        
        System.out.println("rs.getint(1): "+rs.getInt(1));
        cv.getQuestionario().add(new Pergunta(rs.getInt(1),rs.getString("nr_pergunta"), rs.getString("pergunta"),rs.getInt(4),rs.getString("resposta")));
        
        while(rs.next())
        {
            cv.getQuestionario().add(new Pergunta(rs.getInt(1),rs.getString("nr_pergunta"), rs.getString("pergunta"),rs.getInt(4),rs.getString("resposta")));
        }
                
        return cv;
    }
    
}
