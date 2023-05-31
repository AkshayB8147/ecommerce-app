package com.ecommerce.app.service.dao;

import com.ecommerce.app.entity.Category;

import java.util.List;

public interface CategoryService {
    public List<Category> getAllCategories();

    public List<Category> saveAllCategories(List<Category> categories);
}
