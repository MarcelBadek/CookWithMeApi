package org.example.cookwithmeapi.dto.recipe;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.cookwithmeapi.model.Category;
import org.example.cookwithmeapi.model.Recipe;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecipeRequest {
    @NotBlank(message = "Name is mandatory")
    private String name;

    @Min(value = 1, message = "Minimal time is 1 minute")
    private int preparationTime;

    @NotBlank(message = "Ingredients are mandatory")
    private String ingredients;

    @NotBlank(message = "Description is mandatory")
    private String description;

    @NotEmpty(message = "Recipe must have category")
    private List<Category> categories;
}