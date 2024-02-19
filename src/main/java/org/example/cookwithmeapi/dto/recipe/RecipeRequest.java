package org.example.cookwithmeapi.dto.recipe;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.cookwithmeapi.model.Category;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecipeRequest {
    @NotBlank(message = "Name is mandatory")
    @Length(min = 2, message = "Name must be at least 2 characters")
    private String name;

    @NotBlank(message = "Preparation time is mandatory")
    @Min(value = 1, message = "Minimal time is 1 minute")
    private int preparationTime;

    @NotBlank(message = "Ingredients are mandatory")
    @Length(min = 3, message = "Name must be at least 3 characters")
    private String ingredients;

    @NotBlank(message = "Description is mandatory")
    @Length(min = 50, message = "Description must be at least 50 characters")
    private String description;

    @NotEmpty(message = "Recipe must have category")
    private List<Category> categories;
}
