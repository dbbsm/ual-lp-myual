/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ual.myual.models;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import ual.myual.exceptions.CustomGenericException;

/**
 *
 * @author Diogo
 */
@ControllerAdvice
public class GlobalExceptionController {
    
    @ExceptionHandler(CustomGenericException.class)
    public ModelAndView handleCustomException(CustomGenericException ex) {

        ModelAndView model = new ModelAndView("generic_error");
        model.addObject("errCode", ex.getCode());
        model.addObject("errMsg", ex.getMsg());

        return model;

    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleAllException(Exception ex) {

        ModelAndView model = new ModelAndView("generic_error");
        model.addObject("errMsg", "this is Exception.class");

        return model;

    }
    
}
