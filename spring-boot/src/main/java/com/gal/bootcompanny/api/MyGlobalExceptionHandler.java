package com.gal.bootcompanny.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class MyGlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> handleException(Exception e) {

        Map<String, String> map = new HashMap<>();
        map.put("message", e.getMessage());
        map.put("code", HttpStatus.NOT_FOUND.toString());

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(map);
    }
}