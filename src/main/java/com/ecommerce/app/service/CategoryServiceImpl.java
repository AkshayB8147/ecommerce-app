package com.ecommerce.app.service;

import com.ecommerce.app.entity.Category;
import com.ecommerce.app.exceptions.CategoryNotPresentException;
import com.ecommerce.app.repository.CategoryRepository;
import com.ecommerce.app.service.dao.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public List<Category> saveAllCategories(List<Category> categories) {
        return categoryRepository.saveAll(categories);
    }

    @Override
    public Category getCategoryById(Long categoryId) throws CategoryNotPresentException {
        Optional<Category> category = categoryRepository.findById(categoryId);
        if (!category.isPresent()){
            throw new CategoryNotPresentException("Category not found " + categoryId);
        }
        return category.get();
    }

    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Long categoryId, Category category) {
        Category actualCategory = categoryRepository.findById(categoryId).get();

        String name = (actualCategory.getName() == category.getName() && Objects.nonNull(category.getName())) ? actualCategory.getName() : category.getName();

        actualCategory.setName(name);
        return categoryRepository.save(actualCategory);
    }


}
