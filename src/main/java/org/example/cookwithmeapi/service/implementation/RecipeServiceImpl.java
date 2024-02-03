package org.example.cookwithmeapi.service.implementation;

import lombok.AllArgsConstructor;
import org.example.cookwithmeapi.exceptions.RecipeNotFoundException;
import org.example.cookwithmeapi.model.Recipe;
import org.example.cookwithmeapi.repository.implementation.RecipeRepositoryImpl;
import org.example.cookwithmeapi.service.RecipeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class RecipeServiceImpl implements RecipeService {
    private RecipeRepositoryImpl repository;
    @Override
    public List<Recipe> get() {
        return repository.findAll();
    }

    @Override
    public Recipe getById(UUID id) {
        Optional<Recipe> result = repository.findById(id);

        return result.orElseThrow(RecipeNotFoundException::new);
    }

    @Override
    public Recipe create(Recipe recipe) {
        return repository.saveAndFlush(recipe);
    }

    @Override
    public Recipe update(UUID id, Recipe recipe) {
        Optional<Recipe> result = repository.findById(id);

        if (result.isEmpty()) throw new RecipeNotFoundException();

        Recipe resultRecipe = result.get();

        resultRecipe.setName(recipe.getName());
        resultRecipe.setPreparationTime(recipe.getPreparationTime());
        resultRecipe.setIngredients(recipe.getIngredients());
        resultRecipe.setDescription(recipe.getDescription());
        resultRecipe.setCategories(recipe.getCategories());

        return repository.saveAndFlush(resultRecipe);
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }
}
