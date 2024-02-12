package org.example.cookwithmeapi.controller.implementation;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.example.cookwithmeapi.controller.RecipeController;
import org.example.cookwithmeapi.dto.recipe.RecipeResponse;
import org.example.cookwithmeapi.exceptions.NotFoundException;
import org.example.cookwithmeapi.exceptions.message.AccountExceptionMessage;
import org.example.cookwithmeapi.model.Recipe;
import org.example.cookwithmeapi.dto.recipe.RecipeRequest;
import org.example.cookwithmeapi.mapper.RecipeMapper;
import org.example.cookwithmeapi.model.account.Client;
import org.example.cookwithmeapi.service.ClientService;
import org.example.cookwithmeapi.service.RecipeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
    private final ClientService clientService;

    @Override
    @GetMapping()
    public ResponseEntity<List<RecipeResponse>> get() {
        List<Recipe> response = service.get();

        return ResponseEntity.status(HttpStatus.OK).body(response.stream().map(RecipeMapper::toResponse).toList());
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<RecipeResponse> getById(@PathVariable UUID id) {
        Recipe response = service.getById(id);

        return ResponseEntity.status(HttpStatus.OK).body(RecipeMapper.toResponse(response));
    }

    @Override
    @PostMapping
    public ResponseEntity<RecipeResponse> create(@Valid @RequestBody RecipeRequest request) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        Client client = clientService.getByUsername(auth.getName());
        Recipe response = service.create(RecipeMapper.toRecipe(request), client);

        return ResponseEntity.status(HttpStatus.CREATED).body(RecipeMapper.toResponse(response));
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<RecipeResponse> update(@PathVariable UUID id,@Valid @RequestBody RecipeRequest request) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        Client client = clientService.getByUsername(auth.getName());
        Recipe response = service.update(id, RecipeMapper.toRecipe(request), client);

        return ResponseEntity.status(HttpStatus.OK).body(RecipeMapper.toResponse(response));
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        Client client = clientService.getByUsername(auth.getName());

        service.delete(id, client);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
