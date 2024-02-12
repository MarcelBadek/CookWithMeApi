package org.example.cookwithmeapi.service.implementation;

import lombok.AllArgsConstructor;
import org.example.cookwithmeapi.exceptions.NotFoundException;
import org.example.cookwithmeapi.exceptions.message.CategoryExceptionMessage;
import org.example.cookwithmeapi.model.Category;
import org.example.cookwithmeapi.repository.CategoryRepository;
import org.example.cookwithmeapi.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository repository;

    @Override
    public List<Category> get() {
        return repository.findAll();
    }

    @Override
    public Category getById(UUID id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException(CategoryExceptionMessage.NOT_FOUND));
    }

    @Override
    public Category create(Category category) {
        return repository.saveAndFlush(category);
    }

    @Override
    public Category update(UUID id, Category category) {
        Category result = repository.findById(id).orElseThrow(() -> new NotFoundException(CategoryExceptionMessage.NOT_FOUND));

        result.setName(category.getName());

        return repository.saveAndFlush(result);
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public boolean checkCategoriesExisting(List<Category> categories) {
        AtomicBoolean arePresent = new AtomicBoolean(true);

        categories.forEach(category -> {
            if (repository.findById(category.getId()).isEmpty()) {
                arePresent.set(false);
            }
        });

        return arePresent.get();
    }
}
