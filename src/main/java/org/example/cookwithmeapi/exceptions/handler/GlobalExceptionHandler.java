package org.example.cookwithmeapi.exceptions.handler;

import org.example.cookwithmeapi.exceptions.DataUniquenessException;
import org.example.cookwithmeapi.exceptions.NoPermissionException;
import org.example.cookwithmeapi.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<String> handleNotFoundException(NotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<StringBuilder> handleValidationException(MethodArgumentNotValidException exception) {
        StringBuilder builder = new StringBuilder();
        exception.getBindingResult().getAllErrors().forEach(error -> {
            builder.append(error.getDefaultMessage());
            builder.append("\n");
        });

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(builder);
    }

    @ExceptionHandler({DataUniquenessException.class})
    public ResponseEntity<String> handleInvalidDataException(DataUniquenessException exception) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(exception.getMessage());
    }

    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<String> handleNoPermissionException(NoPermissionException exception) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(exception.getMessage());
    }
}
