package org.example.cookwithmeapi.mapper;

import org.example.cookwithmeapi.dto.recipe.RecipeResponse;
import org.example.cookwithmeapi.model.Recipe;
import org.example.cookwithmeapi.dto.recipe.RecipeRequest;

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

    public static RecipeResponse toResponse(Recipe recipe) {
        return RecipeResponse
                .builder()
                .id(recipe.getId())
                .name(recipe.getName())
                .preparationTime(recipe.getPreparationTime())
                .ingredients(recipe.getIngredients())
                .description(recipe.getDescription())
                .categories(recipe.getCategories().stream().map(CategoryMapper::toResponse).toList())
                .author(AccountMapper.toResponse(recipe.getAuthor()))
                .build();
    }
}
