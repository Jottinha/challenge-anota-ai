package com.joaovitor.ferreira.challengeanotaai.services.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class CategoryNotFoundException extends RuntimeException{
    private static final Logger logger = LoggerFactory.getLogger(CategoryNotFoundException.class);
    @ExceptionHandler(CategoryNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Map<String, Object>> handleCategoryNotFoundException(CategoryNotFoundException e) {
        logger.info("------------ Not found category ---------------");
        Map<String, Object> errorResponse = new HashMap<>();

        errorResponse.put("timestamp", LocalDateTime.now());
        errorResponse.put("status", HttpStatus.NOT_FOUND.value());
        errorResponse.put("error", HttpStatus.NOT_FOUND.getReasonPhrase());
        errorResponse.put("path", "/api/categories/");
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
