package org.example.cookwithmeapi.controller.implementation;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.example.cookwithmeapi.controller.CategoryController;
import org.example.cookwithmeapi.dto.category.CategoryResponse;
import org.example.cookwithmeapi.model.Category;
import org.example.cookwithmeapi.dto.category.CategoryRequest;
import org.example.cookwithmeapi.mapper.CategoryMapper;
import org.example.cookwithmeapi.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@AllArgsConstructor
@RestController
@RequestMapping("/categories")
public class CategoryControllerImpl implements CategoryController {
    private final CategoryService service;

    @Override
    @GetMapping()
    public ResponseEntity<List<CategoryResponse>> get() {
        List<Category> response = service.get();

        return ResponseEntity.status(HttpStatus.OK).body(response.stream().map(CategoryMapper::toResponse).toList());
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> getById(@PathVariable UUID id) {
        Category response = service.getById(id);

        return ResponseEntity.status(HttpStatus.OK).body(CategoryMapper.toResponse(response));
    }

    @Override
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<CategoryResponse> create(@Valid @RequestBody CategoryRequest request) {
        Category response = service.create(CategoryMapper.toCategory(request));

        return ResponseEntity.status(HttpStatus.CREATED).body(CategoryMapper.toResponse(response));
    }

    @Override
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<CategoryResponse> update(@PathVariable UUID id, @Valid @RequestBody CategoryRequest request) {
        Category response = service.update(id, CategoryMapper.toCategory(request));

        return ResponseEntity.status(HttpStatus.CREATED).body(CategoryMapper.toResponse(response));
    }

    @Override
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
