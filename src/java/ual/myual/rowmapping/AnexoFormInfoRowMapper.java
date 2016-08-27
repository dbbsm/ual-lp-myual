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
import ual.myual.models.AnexoForm;

/**
 *
 * @author Diogo
 */
public class AnexoFormInfoRowMapper implements RowMapper{
    
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        
        AnexoForm anexo = new AnexoForm();
        
        anexo.setId(rs.getInt("id"));
        
        anexo.setCadeira(rs.getString("nome"));
        anexo.setAno(rs.getInt("ano"));
        
        return anexo;
        
    }
    
}
