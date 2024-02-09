package org.example.cookwithmeapi.controller;

import org.example.cookwithmeapi.model.Recipe;
import org.example.cookwithmeapi.dto.recipe.RecipeRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface RecipeController {
    ResponseEntity<List<Recipe>> get();

    ResponseEntity<Recipe> getById(UUID id);

    ResponseEntity<Recipe> create(RecipeRequest request);

    ResponseEntity<Recipe> update(UUID id, RecipeRequest request);

    ResponseEntity<?> delete(UUID id);
}
