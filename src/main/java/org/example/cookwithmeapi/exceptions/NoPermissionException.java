package org.example.cookwithmeapi.exceptions;

public class NoPermissionException extends RuntimeException {
    public NoPermissionException(String message) {
        super(message);
    }
}
