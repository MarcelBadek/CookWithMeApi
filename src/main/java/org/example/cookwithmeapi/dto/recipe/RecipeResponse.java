package org.example.cookwithmeapi.dto.recipe;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.cookwithmeapi.dto.account.AccountResponse;
import org.example.cookwithmeapi.dto.category.CategoryResponse;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RecipeResponse {
    private UUID id;
    private String name;
    private int preparationTime;
    private String ingredients;
    private String description;
    private List<CategoryResponse> categories;
    private AccountResponse author;
}
