package org.example.cookwithmeapi.controller;

import org.example.cookwithmeapi.dto.category.CategoryResponse;
import org.example.cookwithmeapi.model.Category;
import org.example.cookwithmeapi.dto.category.CategoryRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface CategoryController {
    ResponseEntity<List<CategoryResponse>> get();

    ResponseEntity<CategoryResponse> getById(UUID id);

    ResponseEntity<CategoryResponse> create(CategoryRequest request);

    ResponseEntity<CategoryResponse> update(UUID id, CategoryRequest request);

    ResponseEntity<?> delete(UUID id);
}
