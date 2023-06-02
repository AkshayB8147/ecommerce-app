package com.ecommerce.app.service.dao;

import com.ecommerce.app.entity.Category;
import com.ecommerce.app.exceptions.CategoryNotPresentException;

import java.util.List;

public interface CategoryService {
    public List<Category> getAllCategories();

    public List<Category> saveAllCategories(List<Category> categories);

    public Category getCategoryById(Long categoryId) throws CategoryNotPresentException;

    public Category saveCategory(Category category);

    public Category updateCategory(Long categoryId, Category category);
}
