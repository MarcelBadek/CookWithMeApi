package org.example.cookwithmeapi.mapper;

import org.example.cookwithmeapi.model.Category;
import org.example.cookwithmeapi.dto.category.CategoryRequest;

public class CategoryMapper {
    public static Category toCategory(CategoryRequest request) {
        return new Category(null, request.getName());
    }
}
