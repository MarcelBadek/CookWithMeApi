package org.example.cookwithmeapi.exceptions.handler;

import org.example.cookwithmeapi.exceptions.RecipeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({RecipeNotFoundException.class})
    public ResponseEntity<?> handleRecipeNotFoundException(RecipeNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<?> handleValidationException(MethodArgumentNotValidException exception) {
        StringBuilder builder = new StringBuilder();
        exception.getBindingResult().getAllErrors().forEach(error -> {
            builder.append(error.getDefaultMessage());
            builder.append("\n");
        });

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(builder);
    }
}
