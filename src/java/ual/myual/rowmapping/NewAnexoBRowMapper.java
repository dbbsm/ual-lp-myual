/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ual.myual.rowmapping;

import ual.myual.datamanager.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import ual.myual.models.AnexoB;
import ual.myual.models.Pergunta;

/**
 *
 * @author Diogo
 */
public class NewAnexoBRowMapper implements RowMapper{
    
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        
        AnexoB anexo = new AnexoB();
        
        anexo.getAnexo().add(new Pergunta(rs.getInt("id"),rs.getString("nr_pergunta"), rs.getString("pergunta")));
        
        while(rs.next())
        {
            anexo.getAnexo().add(new Pergunta(rs.getInt("id"),rs.getString("nr_pergunta"), rs.getString("pergunta")));
        }
                
        return anexo;
    }
    
}
