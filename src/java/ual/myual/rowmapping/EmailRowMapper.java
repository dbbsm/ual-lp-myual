/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ual.myual.rowmapping;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import ual.myual.models.Email;


/**
 *
 * @author Diogo
 */
public class EmailRowMapper implements RowMapper{
    
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        
        Email e = new Email();
        
        e.setEmail(rs.getString("email"));
        e.setPassword(rs.getString("password"));
        
        return e;
    }
    
}
