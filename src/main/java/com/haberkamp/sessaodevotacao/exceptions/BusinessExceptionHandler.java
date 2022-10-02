package com.haberkamp.sessaodevotacao.exceptions;

import com.haberkamp.sessaodevotacao.dto.ErrorDetailsDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class BusinessExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorDetailsDTO> handleException(BusinessException exception, WebRequest request) {
        ErrorDetailsDTO erro = new ErrorDetailsDTO(new Date(), exception.getMessage(), HttpStatus.BAD_REQUEST.value()
                , HttpStatus.BAD_REQUEST.name(), ((ServletWebRequest) request).getRequest().getRequestURI());
        return new ResponseEntity<>(erro, HttpStatus.BAD_REQUEST);
    }

}
