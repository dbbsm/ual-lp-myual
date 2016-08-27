/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ual.myual.rowmapping;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import ual.myual.models.User;

/**
 *
 * @author Diogo
 */
public class UserRowMapper implements RowMapper{
    
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        
        User user = new User();
        
        user.setId(rs.getInt("id"));
        user.setUsername(rs.getString("username"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));
        user.setTipo(rs.getString("tipo"));
        
        return user;
    }
    
}
