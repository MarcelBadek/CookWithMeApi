package org.example.cookwithmeapi.controller.implementation;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.example.cookwithmeapi.controller.CategoryController;
import org.example.cookwithmeapi.model.Category;
import org.example.cookwithmeapi.model.dto.category.CategoryRequest;
import org.example.cookwithmeapi.model.mapper.CategoryMapper;
import org.example.cookwithmeapi.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@AllArgsConstructor
@RestController
@RequestMapping("/category")
public class CategoryControllerImpl implements CategoryController {
    private CategoryService service;

    @Override
    @GetMapping()
    public ResponseEntity<List<Category>> get() {
        return ResponseEntity.status(HttpStatus.OK).body(service.get());
    }

    @Override
    @GetMapping("{/id}")
    public ResponseEntity<Category> getById(@PathVariable UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.getById(id));
    }

    @Override
    @PostMapping
    public ResponseEntity<Category> create(@Valid @RequestBody CategoryRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(CategoryMapper.toCategory(request)));
    }

    @Override
    @PutMapping("{/id}")
    public ResponseEntity<Category> update(@PathVariable UUID id, @Valid @RequestBody CategoryRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.update(id, CategoryMapper.toCategory(request)));
    }

    @Override
    @DeleteMapping("{/id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
