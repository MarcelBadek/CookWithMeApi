package org.example.cookwithmeapi.exceptions;

import org.example.cookwithmeapi.exceptions.message.RecipeExceptionMessage;

public class RecipeNotFoundException extends RuntimeException {
    public RecipeNotFoundException() {
        super(RecipeExceptionMessage.NOT_FOUND);
    }
}
