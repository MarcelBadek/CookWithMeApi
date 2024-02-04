package org.example.cookwithmeapi.service.implementation;

import lombok.AllArgsConstructor;
import org.example.cookwithmeapi.exceptions.NotFoundException;
import org.example.cookwithmeapi.exceptions.message.CategoryExceptionMessage;
import org.example.cookwithmeapi.model.Category;
import org.example.cookwithmeapi.repository.implementation.CategoryRepositoryImpl;
import org.example.cookwithmeapi.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepositoryImpl repository;

    @Override
    public List<Category> get() {
        return repository.findAll();
    }

    @Override
    public Category getById(UUID id) {
        Optional<Category> result = repository.findById(id);

        if (result.isEmpty()) throw new NotFoundException(CategoryExceptionMessage.NOT_FOUND);

        return result.get();
    }

    @Override
    public Category create(Category category) {
        return repository.saveAndFlush(category);
    }

    @Override
    public Category update(UUID id, Category category) {
        Optional<Category> result = repository.findById(id);

        if (result.isEmpty()) throw new NotFoundException(CategoryExceptionMessage.NOT_FOUND);

        Category resultCategory = result.get();

        resultCategory.setName(category.getName());

        return repository.saveAndFlush(resultCategory);
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }
}
