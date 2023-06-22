package com.ecommerce.app.service.dao;

import com.ecommerce.app.entity.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getAllCategories();

    Category readCategory(String categoryName);

    Category readCategory(Long categoryId);

    void saveCategory(Category category);

    void updateCategory(Long categoryId, Category category);

}

