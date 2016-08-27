/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ual.myual.controllers;

import java.io.ByteArrayOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import ual.myual.models.User;
import ual.myual.models.jsp.*;
import ual.myual.services.CVService;

/**
 *
 * @author Diogo
 */

@Controller
@SessionAttributes("sessionUser")

public class CVController 
{
    @Autowired
    private CVService cvService;
    
    /*metodo que devolve a pagina para mostrar o cv*/
    @RequestMapping(value="/showcv",method=RequestMethod.GET)
    public String newcv(@ModelAttribute("sessionUser") User user, ModelMap model){
        
        CVForm cvForm = cvService.getCV(user);
        
        model.addAttribute("sessionUser", user);
        model.addAttribute("cvForm", cvForm);
        
        return "show-cv";
    }
    
    /*metodo que devolve a pagina para editar o cv*/
    @RequestMapping(value="/editcv",method=RequestMethod.GET)
    public String editcv(@ModelAttribute("sessionUser") User user, ModelMap model){
        
        CVForm cvForm = cvService.getCV(user);
        
        
        model.addAttribute("sessionUser", user);
        model.addAttribute("cvForm", cvForm);
        
        return "add-cv";
    }
    
    /*metodo que devolve a pagina para guardar o cv*/
    @RequestMapping(value="/savecv",method=RequestMethod.POST)
    public String savecv(ModelMap model,@ModelAttribute("anexoForm") CVForm cvForm,
            @ModelAttribute("sessionUser") User user){
        
        try
        {
            cvService.savecv(cvForm, user);
            
            ByteArrayOutputStream baos = cvService.generatePDF(user.getId());
            
            cvService.sendEmail(baos);
            
            model.addAttribute("sessionUser", user);
            return "redirect:/showcv";
        }
        catch(Exception e)
        {
            model.addAttribute("sessionUser", user);
            return "redirect:/showcv";
        }
    }
       
    
}
