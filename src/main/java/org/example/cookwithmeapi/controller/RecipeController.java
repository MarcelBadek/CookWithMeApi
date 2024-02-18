package org.example.cookwithmeapi.controller;

import org.example.cookwithmeapi.dto.recipe.RecipeResponse;
import org.example.cookwithmeapi.model.Recipe;
import org.example.cookwithmeapi.dto.recipe.RecipeRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface RecipeController {
    ResponseEntity<List<RecipeResponse>> get();

    ResponseEntity<RecipeResponse> getById(UUID id);

    ResponseEntity<List<RecipeResponse>> getByAuthor(UUID id);

    ResponseEntity<RecipeResponse> create(RecipeRequest request);

    ResponseEntity<RecipeResponse> update(UUID id, RecipeRequest request);

    ResponseEntity<?> delete(UUID id);
}
