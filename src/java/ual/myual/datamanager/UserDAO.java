/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ual.myual.datamanager;


import ual.myual.rowmapping.UserRowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
 
import javax.sql.DataSource;
 
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import ual.myual.models.User;
/**
 *
 * @author Diogo
 */
public class UserDAO {
    
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
 
    public void setDataSource(DataSource dataSource) {
      this.dataSource = dataSource;
      this.jdbcTemplate = new JdbcTemplate(dataSource);
   }
    
    public void newUser(User user){
    
        // insert
        String sql = "INSERT INTO users (username, email, password, tipo)"
                    + " VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, user.getUsername(), user.getEmail(),
                user.getPassword(), user.getTipo());
    }
    
    public User getUser(int userId) {
        String sql = "SELECT * FROM users WHERE id=" + userId;
        
        
        User user = (User)jdbcTemplate.queryForObject(sql, new UserRowMapper());
        
        return user;
    }
    
    public void editUser(User user)
    {
        String sql="UPDATE users SET email = ? , password = ? where id = ?";
        
        jdbcTemplate.update(sql, user.getEmail(), user.getPassword(), user.getId());
        
    }
    
    //validar user
    public User validateUser(User user)
    {
        
        String sql = ("Select id,email,username,password,tipo from users where username='"+user.getUsername()+"' and password='"+user.getPassword()+"'");
        
        User u = (User)jdbcTemplate.queryForObject(sql, new UserRowMapper());
        
        return u;
        
    }
}
