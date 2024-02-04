package org.example.cookwithmeapi.service;

import org.example.cookwithmeapi.model.Recipe;

import java.util.List;
import java.util.UUID;

public interface RecipeService {
    List<Recipe> get();

    Recipe getById(UUID id);

    Recipe create(Recipe recipe);

    Recipe update(UUID id, Recipe recipe);

    void delete(UUID id);
}
