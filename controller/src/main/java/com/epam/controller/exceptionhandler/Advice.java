package com.epam.controller.exceptionhandler;

import com.epam.service.exception.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class Advice {

    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<Object> handleException(ServiceException e) {
        List<String> list = new ArrayList<>();
        list.add(e.getMessage());
        list.add(HttpStatus.OK.getReasonPhrase());
        return ResponseEntity.ok(list);
    }
}
