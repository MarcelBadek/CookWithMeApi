package org.example.cookwithmeapi.controller.implementation;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.example.cookwithmeapi.controller.RecipeController;
import org.example.cookwithmeapi.model.Recipe;
import org.example.cookwithmeapi.dto.recipe.RecipeRequest;
import org.example.cookwithmeapi.mapper.RecipeMapper;
import org.example.cookwithmeapi.service.RecipeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@AllArgsConstructor
@RestController()
@RequestMapping("/recipe")
public class RecipeControllerImpl implements RecipeController {
    private final RecipeService service;

    @Override
    @GetMapping()
    public ResponseEntity<List<Recipe>> get() {
        return ResponseEntity.status(HttpStatus.OK).body(service.get());
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Recipe> getById(@PathVariable UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.getById(id));
    }

    @Override
    @PostMapping
    public ResponseEntity<Recipe> create(@Valid @RequestBody RecipeRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(RecipeMapper.toRecipe(request)));
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<Recipe> update(@PathVariable UUID id,@Valid @RequestBody RecipeRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(service.update(id, RecipeMapper.toRecipe(request)));
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
