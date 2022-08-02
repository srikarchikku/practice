package com.project.springboot.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import javax.validation.UnexpectedTypeException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public Map<String, Object> handleValidationErrors(ConstraintViolationException ex)
    {
        Map<String, Object> error = new HashMap<>();
        List<String> body = new ArrayList<>();
	    body=ex.getConstraintViolations()
                .stream()
                .map(x ->x.getMessage())
                .collect(Collectors.toList());
        error.put("errors", body);

        log.info("Some data is incorrect please check");

        return error;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DataIntegrityViolationException.class)
    public Map<String, String> handleDulipateErrors(DataIntegrityViolationException ex) {

        String error = "Duplicate entry is not allowed... please check again";

        Map<String, String> body= new HashMap<>();
        body.put("ErrorMessage: ", error);
        log.info("Duplicate entry is not allowed... please check again");
        return body;

    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(IdNotFoundException.class)
    public Map<String, String> handleNotFoundErrors(IdNotFoundException ex)
    {
        Map<String, String> error = new HashMap<>();
        error.put("ErrorMessage: ", ex.getMessage());
        log.info("The given id is not found in database...");
        return error;
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(UnexpectedTypeException.class)
    public Map<String, String> handleDateErrors(UnexpectedTypeException ex) {

        String error = "Date format is not Valid(YYYY-MM-DD)";

        Map<String, String> body= new HashMap<>();
        body.put("ErrorMessage: ", error);
        log.info("Date format is not Valid(YYYY-MM-DD)");
        return body;

    }

}
