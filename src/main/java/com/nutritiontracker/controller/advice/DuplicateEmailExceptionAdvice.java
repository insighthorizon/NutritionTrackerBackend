package com.nutritiontracker.controller.advice;

import com.nutritiontracker.model.exception.DuplicateEmailException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * global exception handlers
 */
@ControllerAdvice
public class DuplicateEmailExceptionAdvice {

    @ExceptionHandler({DuplicateEmailException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST) // will only respond with this code to the client (400)
    public void handleEntityNotFoundException() { }

}
