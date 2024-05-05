package com.service.hotelservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import com.service.hotelservice.payload.ApiResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

    // triggred when data not found
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ApiResponse<String>> handleResourceNotFoundException(ResourceNotFoundException ex,
            WebRequest request) {
        ApiResponse<String> response = new ApiResponse<>(ex.getMessage(), true, null);
        return new ResponseEntity(response, HttpStatus.NOT_FOUND);
    }

    // triggred when dtos validation fails
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ApiResponse<String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        // Creating ApiResponse with validation errors
        ApiResponse<String> response = new ApiResponse<String>(
                ex.getBindingResult().getFieldError().getDefaultMessage(), false,
                null);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
