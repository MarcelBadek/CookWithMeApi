package org.example.cookwithmeapi.service;

import org.example.cookwithmeapi.model.Category;

import java.util.List;
import java.util.UUID;

public interface CategoryService {
    List<Category> get();

    Category getById(UUID id);

    Category create(Category category);

    Category update(UUID id, Category category);

    void delete(UUID id);
}
