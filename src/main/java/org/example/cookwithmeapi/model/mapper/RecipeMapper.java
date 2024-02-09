package org.example.cookwithmeapi.model.mapper;

import org.example.cookwithmeapi.model.Recipe;
import org.example.cookwithmeapi.model.dto.recipe.RecipeRequest;

public class RecipeMapper {
    public static Recipe toRecipe(RecipeRequest request) {
        return new Recipe(null,
                request.getName(),
                request.getPreparationTime(),
                request.getIngredients(),
                request.getDescription(),
                request.getCategories(),
                null);
    }
}
