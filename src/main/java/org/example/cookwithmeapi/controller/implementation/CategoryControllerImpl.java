package org.example.cookwithmeapi.controller.implementation;

import lombok.AllArgsConstructor;
import org.example.cookwithmeapi.controller.CategoryController;
import org.example.cookwithmeapi.model.Category;
import org.example.cookwithmeapi.model.dto.category.CategoryRequest;
import org.example.cookwithmeapi.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@Controller
@AllArgsConstructor
@RestController
@RequestMapping("/category")
public class CategoryControllerImpl implements CategoryController {
    private CategoryService service;

    @Override
    public ResponseEntity<List<Category>> get() {
        return ResponseEntity.status(HttpStatus.OK).body(service.get());
    }

    @Override
    public ResponseEntity<Category> getById(UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.getById(id));
    }

    @Override
    public ResponseEntity<Category> create(CategoryRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(CategoryRequest.toCategory(request)));
    }

    @Override
    public ResponseEntity<Category> update(UUID id, CategoryRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.update(id, CategoryRequest.toCategory(request)));
    }

    @Override
    public ResponseEntity<?> delete(UUID id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
