package org.example.cookwithmeapi.controller;

import org.example.cookwithmeapi.model.Recipe;

import java.util.List;
import java.util.UUID;

public interface RecipeController {
    public List<Recipe> get();

    public Recipe getById(UUID id);

    public Recipe create(Recipe recipe);

    public Recipe update(UUID id, Recipe recipe);

    public void delete(UUID id);
}
