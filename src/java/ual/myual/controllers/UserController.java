/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ual.myual.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import ual.myual.datamanager.UserDAO;
import ual.myual.exceptions.CustomGenericException;
import ual.myual.models.User;
import ual.myual.services.UserService;

/**
 *
 * @author Diogo
 */
@Controller
@SessionAttributes("sessionUser")
public class UserController {
    
    @Autowired
    private UserService userService;
    
    
    @RequestMapping(value="/profile",method=RequestMethod.GET)
    public String showUser(ModelMap model)
    {
        return "show-user";
    }
    
    @RequestMapping(value="/editProfile",method=RequestMethod.GET)
    public String editUser(ModelMap model)
    {
        return "add-user";
    }
    
    @RequestMapping(value="/editProfile",method=RequestMethod.POST)
    public String saveUser(@ModelAttribute("user") User user, ModelMap model,@ModelAttribute("sessionUser") User u)
    {
        
        user.setId(u.getId());
        
        userService.edit(user);
        
        User sessionUser = userService.getUserInfo(user.getId());
        
        model.addAttribute("sessionUser", sessionUser);
        
        return "redirect:/profile";
    }
    
    
    @RequestMapping(value="/validate",method=RequestMethod.POST)
    public String enter(@ModelAttribute("user") User user, ModelMap model){
    
        try{
            
            User sessionUser=userService.validate(user);
            model.addAttribute("sessionUser",sessionUser);
            
            return "redirect:/menu";
        }
        catch(Exception e)
        {
            model.addAttribute("error", new CustomGenericException("A combinação que introduzio nao existe."));
            return "redirect:/login";
        }        
            
    }
    
}
