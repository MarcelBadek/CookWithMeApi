package org.example.cookwithmeapi.service;

import org.example.cookwithmeapi.model.Recipe;
import org.example.cookwithmeapi.model.account.Client;

import java.util.List;
import java.util.UUID;

public interface RecipeService {
    List<Recipe> get();

    Recipe getById(UUID id);

    Recipe create(Recipe recipe, Client owner);

    Recipe update(UUID id, Recipe recipe, Client requestedBy);

    void delete(UUID id, Client requestedBy);
}
