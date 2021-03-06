package com.web.exception;


import com.entities.dtos.ResponseDto;
import io.jsonwebtoken.JwtException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
//@ControllerAdvice
public class CustomException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseDto inValidArguments(MethodArgumentNotValidException ex) {
        Map<Object, String> errors = new HashMap<>();
        //collect errors
        for (final FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.put(error.getField(), error.getDefaultMessage());
        }
        return new ResponseDto("Miss parameters", "ERROR", errors);
    }

    @ExceptionHandler({RuntimeException.class})
    public ResponseDto inValidArguments(RuntimeException ex) {
        return new ResponseDto("Failed handle", "ERROR", ex.getMessage());
    }
}
