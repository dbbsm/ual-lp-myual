/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ual.myual.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import ual.myual.models.User;

/**
 *
 * @author Diogo
 */
@Controller
@SessionAttributes("sessionUser")
public class GeneralController {
    
    @RequestMapping(value="/inicio")
    public String inicio(){
        return "inicio";
    }
    
    @RequestMapping(value="/login",method=RequestMethod.GET)
    public String login(){
    
        return"login";
    }
    
    @RequestMapping(value="/menu",method=RequestMethod.GET)
    public String menu(ModelMap model, @ModelAttribute("sessionUser") User user){
        
        model.addAttribute("sessionUser", user);
        
        if(user.getTipo().equalsIgnoreCase("a"))
        {
            return "menualunos";
        }
        else if(user.getTipo().equalsIgnoreCase("d"))
            return "menuprofessores";
        
        return null;
    }
    
    @RequestMapping(value="/logout",method=RequestMethod.GET)
    public String logout(ModelMap model, @ModelAttribute("sessionUser") User user){
        
        user= new User();
        
        model.addAttribute("sessionUser", user);
        
        return "logout";
    }
}
