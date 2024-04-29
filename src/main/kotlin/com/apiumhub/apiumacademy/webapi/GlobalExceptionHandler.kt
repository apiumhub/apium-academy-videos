package com.apiumhub.apiumacademy.webapi;

import com.apiumhub.apiumacademy.domain.exceptions.StudentsInCourseLimitReachedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({StudentsInCourseLimitReachedException.class})
    public ResponseEntity<Object> handleStudentNotFoundException(StudentsInCourseLimitReachedException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }
}