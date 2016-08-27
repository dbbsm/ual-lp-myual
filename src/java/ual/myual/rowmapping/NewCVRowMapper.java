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
public class NewCVRowMapper implements RowMapper{
    
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        
        CV cv = new CV();
        
        cv.getQuestionario().add(new Pergunta(rs.getInt("id"),rs.getString("nr_pergunta"), rs.getString("pergunta")));
        
        while(rs.next())
        {
            cv.getQuestionario().add(new Pergunta(rs.getInt("id"),rs.getString("nr_pergunta"), rs.getString("pergunta")));
        }
                
        return cv;
    }
    
}
