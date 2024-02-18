package org.example.cookwithmeapi.service.implementation;

import lombok.AllArgsConstructor;
import org.example.cookwithmeapi.exceptions.NoPermissionException;
import org.example.cookwithmeapi.exceptions.NotFoundException;
import org.example.cookwithmeapi.exceptions.message.AccountExceptionMessage;
import org.example.cookwithmeapi.exceptions.message.CategoryExceptionMessage;
import org.example.cookwithmeapi.exceptions.message.RecipeExceptionMessage;
import org.example.cookwithmeapi.model.Recipe;
import org.example.cookwithmeapi.model.account.Account;
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
    public List<Recipe> getByAuthor(UUID id) {
        return repository.findAllByAuthorId(id);
    }

    @Override
    public Recipe create(Recipe recipe, Client owner) {
        if (!categoryService.checkCategoriesExisting(recipe.getCategories())) {
            throw new NotFoundException(CategoryExceptionMessage.NOT_FOUND);
        }

        recipe.setAuthor(owner);

        return repository.saveAndFlush(recipe);
    }

    @Override
    public Recipe update(UUID id, Recipe recipe, Client requestedBy) {
        Recipe result = repository.findById(id).orElseThrow(() -> new NotFoundException(RecipeExceptionMessage.NOT_FOUND));

        if (result.getAuthor().getId() != requestedBy.getId()) {
            throw new NoPermissionException(AccountExceptionMessage.NO_PERMISSION);
        }

        if (!categoryService.checkCategoriesExisting(recipe.getCategories())) {
            throw new NotFoundException(CategoryExceptionMessage.NOT_FOUND);
        }

        result.setName(recipe.getName());
        result.setPreparationTime(recipe.getPreparationTime());
        result.setIngredients(recipe.getIngredients());
        result.setDescription(recipe.getDescription());
        result.setCategories(recipe.getCategories());

        return repository.saveAndFlush(result);
    }

    @Override
    public void delete(UUID id, Client requestedBy) {
        Recipe result = repository.findById(id).orElseThrow(() -> new NotFoundException(RecipeExceptionMessage.NOT_FOUND));

        if (result.getAuthor().getId() != requestedBy.getId()) {
            throw new NoPermissionException(AccountExceptionMessage.NO_PERMISSION);
        }

        repository.deleteById(id);
    }
}
