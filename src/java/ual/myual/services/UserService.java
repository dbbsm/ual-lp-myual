/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ual.myual.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ual.myual.datamanager.UserDAO;
import ual.myual.models.User;

/**
 *
 * @author Diogo
 */
@Service
public class UserService {
    
    @Autowired
    private UserDAO userDAO;
    
    public UserService() {
    }
    
    public void newUser(User user)
    {
        userDAO.newUser(user);
    }
    
    public User getUserInfo(int id)
    {
        User user = userDAO.getUser(id);
        
        return user;
    }
    
    public User validate(User u)
    {
        User user = userDAO.validateUser(u);
        
        return user;
    }
    
    public User edit(User u)
    {
        userDAO.editUser(u);
        
        User user = userDAO.getUser(u.getId());
        
        return user;
    }
}
