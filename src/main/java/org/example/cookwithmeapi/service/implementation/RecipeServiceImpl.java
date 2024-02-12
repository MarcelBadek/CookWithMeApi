package org.example.cookwithmeapi.service.implementation;

import lombok.AllArgsConstructor;
import org.example.cookwithmeapi.exceptions.NotFoundException;
import org.example.cookwithmeapi.exceptions.message.AccountExceptionMessage;
import org.example.cookwithmeapi.exceptions.message.CategoryExceptionMessage;
import org.example.cookwithmeapi.exceptions.message.RecipeExceptionMessage;
import org.example.cookwithmeapi.model.Recipe;
import org.example.cookwithmeapi.model.account.Client;
import org.example.cookwithmeapi.repository.ClientRepository;
import org.example.cookwithmeapi.repository.RecipeRepository;
import org.example.cookwithmeapi.service.CategoryService;
import org.example.cookwithmeapi.service.RecipeService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class RecipeServiceImpl implements RecipeService {
    private final RecipeRepository repository;
    private final ClientRepository clientRepository;
    private final CategoryService categoryService;

    @Override
    public List<Recipe> get() {
        return repository.findAll();
    }

    @Override
    public Recipe getById(UUID id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException(RecipeExceptionMessage.NOT_FOUND));
    }

    @Override
    public Recipe create(Recipe recipe) {
        if (!categoryService.checkCategoriesExisting(recipe.getCategories())) {
            throw new NotFoundException(CategoryExceptionMessage.NOT_FOUND);
        }

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        Client client = clientRepository.findByUsername(auth.getName()).orElseThrow(() ->  new NotFoundException(AccountExceptionMessage.NOT_FOUND_CREATING_RECIPE) );
        recipe.setAuthor(client);

        return repository.saveAndFlush(recipe);
    }

    @Override
    public Recipe update(UUID id, Recipe recipe) {
        if (!categoryService.checkCategoriesExisting(recipe.getCategories())) {
            throw new NotFoundException(CategoryExceptionMessage.NOT_FOUND);
        }

        Recipe result = repository.findById(id).orElseThrow(() -> new NotFoundException(RecipeExceptionMessage.NOT_FOUND));

        result.setName(recipe.getName());
        result.setPreparationTime(recipe.getPreparationTime());
        result.setIngredients(recipe.getIngredients());
        result.setDescription(recipe.getDescription());
        result.setCategories(recipe.getCategories());

        return repository.saveAndFlush(result);
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }
}
