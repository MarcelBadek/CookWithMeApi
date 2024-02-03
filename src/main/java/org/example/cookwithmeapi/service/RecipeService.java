package org.example.cookwithmeapi.service;

import org.example.cookwithmeapi.exceptions.RecipeNotFoundException;
import org.example.cookwithmeapi.model.Recipe;

import java.util.List;
import java.util.UUID;

public interface RecipeService {
    public List<Recipe> get();

    public Recipe getById(UUID id);

    public Recipe create(Recipe recipe);

    public Recipe update(UUID id, Recipe recipe);

    public void delete(UUID id);
}
