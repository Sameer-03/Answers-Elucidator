/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DIscussionForum.AnwersElucidator.CustomExceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 *
 * @author Sameer
 */
@ControllerAdvice
public class AdviceTesting extends ResponseEntityExceptionHandler{
    @ExceptionHandler(Exception.class)
    public String handle(RuntimeException e)
    {
        return "User or Question not available";
    }
    
    
}
