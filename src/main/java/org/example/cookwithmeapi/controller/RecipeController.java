package org.example.cookwithmeapi.controller;

import org.example.cookwithmeapi.model.Recipe;
import org.example.cookwithmeapi.model.dto.recipe.RecipeRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface RecipeController {
    public ResponseEntity<List<Recipe>> get();

    public ResponseEntity<Recipe> getById(UUID id);

    public ResponseEntity<Recipe> create(RecipeRequest request);

    public ResponseEntity<Recipe> update(UUID id, RecipeRequest request);

    public ResponseEntity<?> delete(UUID id);
}
