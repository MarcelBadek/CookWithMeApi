package org.example.cookwithmeapi.controller;

import org.example.cookwithmeapi.model.Category;
import org.example.cookwithmeapi.model.dto.category.CategoryRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface CategoryController {
    ResponseEntity<List<Category>> get();

    ResponseEntity<Category> getById(UUID id);

    ResponseEntity<Category> create(CategoryRequest request);

    ResponseEntity<Category> update(UUID id, CategoryRequest request);

    ResponseEntity<?> delete(UUID id);
}
