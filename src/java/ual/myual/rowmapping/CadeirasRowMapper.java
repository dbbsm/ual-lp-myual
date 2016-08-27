/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ual.myual.rowmapping;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import ual.myual.models.UnidadeCurricular;

/**
 *
 * @author Diogo
 */
public class CadeirasRowMapper implements RowMapper{
    
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        
        UnidadeCurricular cadeira = new UnidadeCurricular(rs.getInt("id"),rs.getString("nome"));
        
        return cadeira;
        
    }
    
}
