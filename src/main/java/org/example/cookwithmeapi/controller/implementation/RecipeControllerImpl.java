package org.example.cookwithmeapi.controller.implementation;

import lombok.AllArgsConstructor;
import org.example.cookwithmeapi.controller.RecipeController;
import org.example.cookwithmeapi.model.Recipe;
import org.example.cookwithmeapi.service.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@AllArgsConstructor
@RestController()
@RequestMapping("/recipe")
public class RecipeControllerImpl implements RecipeController {
    private RecipeService service;
    @Override
    @GetMapping()
    public List<Recipe> get() {
        return service.get();
    }

    @Override
    @GetMapping("/{id}")
    public Recipe getById(@PathVariable UUID id) {
        return service.getById(id);
    }

    @Override
    @PostMapping
    public Recipe create(@RequestBody Recipe recipe) {
        return service.create(recipe);
    }

    @Override
    @PutMapping
    public Recipe update(@RequestBody UUID id, @RequestBody Recipe recipe) {
        return service.update(id, recipe);
    }

    @Override
    @DeleteMapping
    public void delete(@RequestBody UUID id) {
        service.delete(id);
    }
}
