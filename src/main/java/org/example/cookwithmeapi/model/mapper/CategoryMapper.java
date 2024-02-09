package org.example.cookwithmeapi.model.mapper;

import org.example.cookwithmeapi.model.Category;
import org.example.cookwithmeapi.model.dto.category.CategoryRequest;

public class CategoryMapper {
    public static Category toCategory(CategoryRequest request) {
        return new Category(null, request.getName());
    }
}
