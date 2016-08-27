/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ual.myual.controllers;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import ual.myual.exceptions.CustomGenericException;
import ual.myual.models.*;
import ual.myual.services.AnexoService;

/**
 *
 * @author Diogo
 */
@Controller
@SessionAttributes("sessionUser")

public class AnexoController {
    
    @Autowired
    private AnexoService anexoService;
    
    
    /* funçao temporaria*/
    
    
    /*metodo que devolve a pagina para preencher um anexo em branco*/
    @RequestMapping(value="/newanexo",method=RequestMethod.GET)
    public String newanexo(ModelMap model){
        
        AnexoForm anexoForm = anexoService.newAnexo();
        
        ArrayList<UnidadeCurricular> cadeiras = anexoService.getCadeiras();
        
        anexoForm.setPergunta10(new Pergunta10());
        
        model.addAttribute("cadeiras", cadeiras);
        model.addAttribute("anexoForm", anexoForm);
        
        return "add-anexo";
    }
    
    /*metodo que copia o anexo que o professor esta a visualizar e dá 
    a possibilidade de criar um novo apartir daquele*/
    @RequestMapping(value="/copyanexo",method=RequestMethod.GET)
    public String copyanexo(ModelMap model, @RequestParam int id){
        
        AnexoForm anexoForm = anexoService.getCopyAnexo(id);
        
        ArrayList<UnidadeCurricular> cadeiras = anexoService.getCadeiras();
        
        model.addAttribute("cadeiras", cadeiras);
        model.addAttribute("anexoForm", anexoForm);
        
        return "add-anexo";
    }
    
    /*metodo que remove o anexo da listagem do professor*/
    @RequestMapping(value="/removeanexo/{id}",method=RequestMethod.GET)
    public String removeanexo(ModelMap model, @PathVariable int id){
        
        anexoService.setEstadoDeleted(id);
        
        return "redirect:/listaranexos";
    }
    
    /*metodo que remove o anexo da listagem do professor*/
    @RequestMapping(value="/showanexo",method=RequestMethod.GET)
    public String showanexo(ModelMap model, @RequestParam int id){
        
        AnexoForm anexoForm = anexoService.getCopyAnexo(id);
        
        model.addAttribute("id", id);
        model.addAttribute("anexoForm", anexoForm);
        
        return "show-anexo";
    }
    
    /*metodo que imprime o anexo da listagem do professor*/
    @RequestMapping(value="/imprimiranexo",method=RequestMethod.GET)
    public String imprimiranexo(ModelMap model, HttpServletResponse response, @RequestParam int id){
				
	try 
	{
            
            ByteArrayOutputStream baos = anexoService.generatePDF(id);
            
            response.setHeader("Content-Disposition","attachment;filename=anexo.pdf");

            response.setContentType("application/pdf");
            response.setContentLength(baos.size());
            
            ServletOutputStream out = response.getOutputStream();
            baos.writeTo(out);
            out.flush();
            
					
	}	  
        catch(Exception e){}
        
        return "redirect:/listaranexos";
        
    }
    
    /*metodo que lista todos os anexos já preenchidos pelo docente*/
    @RequestMapping(value="/listaranexos",method=RequestMethod.GET)
    public String listaranexos(ModelMap model, @ModelAttribute("sessionUser") User user){
        
        ArrayList<AnexoForm> anexosForm = anexoService.getAllAnexos(user);
        
        model.addAttribute("sessionUser", user);
        model.addAttribute("anexosForm", anexosForm);
        
        return "list-anexos";
        
    }
    
    /*metodo que guarda o anexo preenchido na base de dados, envia por mail e
    devolve a vista do anexo sem possibilidade de editar respostas*/
    @RequestMapping(value="/saveanexo", method=RequestMethod.POST)
    public String saveanexo(ModelMap model, @ModelAttribute("anexoForm") AnexoForm anexoForm,
            @ModelAttribute("sessionUser") User user){
        
        try
        {
            System.out.println("Cadeira:"+anexoForm.getAnexo().get(0).getResposta());
            model.addAttribute("sessionUser", user);
            
            boolean pergunta10_isvalid= anexoService.validatePergunta10(anexoForm);
            
            if(pergunta10_isvalid)
            {
                int id = anexoService.saveAnexo(user, anexoForm);

                ByteArrayOutputStream baos = anexoService.generatePDF(id);

                anexoService.sendEmail(baos);

                
                return "redirect:/listaranexos";
            
            }
            else
            {
                
                model.addAttribute("anexoForm", anexoForm);
                return "redirect:/newanexo";
            }           
            
        }
        catch(Exception e)
        {
            model.addAttribute("sessionUser", user);
            System.out.println("erro: "+e.getMessage());            
            return "redirect:/listaranexos";
        }
        
    }
    
    
    
    
    /*
    
    
    @RequestMapping(value="/removeanexo/{id}",method=RequestMethod.GET)
    public String removeanexo(ModelMap model, @PathVariable int id){
        
        anexoService.setEstadoDeleted(id);
        
        return "redirect: listaranexos";
    }
    
    @RequestMapping(value="/removeanexo",method=RequestMethod.GET)
    public String removeanexo(ModelMap model, @RequestParam int id){
        
        anexoService.setEstadoDeleted(id);
        
        return "redirect: listaranexos";
    }
    
    
    @RequestMapping(value="/getanexo",method=RequestMethod.GET)
    public String getanexo(ModelMap model, @RequestParam int id){
        
        AnexoForm anexoForm = anexoService.getAnexo(id);
        
        model.addAttribute("anexoForm", anexoForm);
        
        return "show-anexo";
    }
    
    
    @RequestMapping(value="/getallanexos",method=RequestMethod.GET)
    public String getanexo(ModelMap model, @ModelAttribute("userObj") User user){
        
        ArrayList<AnexoForm> anexosForm = anexoService.getAllAnexos(user);
        
        model.addAttribute("anexosForm", anexosForm);
        
        return "list-anexos";
    }
    */
    
}
