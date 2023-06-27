package com.ecommerce.app.service;

import com.ecommerce.app.entity.Category;
import com.ecommerce.app.exceptions.ResourceNotFoundException;
import com.ecommerce.app.repository.CategoryRepository;
import com.ecommerce.app.service.dao.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category readCategory(String categoryName) {
        return categoryRepository.getByName(categoryName);
    }

    @Override
    public Category readCategory(Long categoryId) throws ResourceNotFoundException{
        return categoryRepository.findById(categoryId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Category", "id", categoryId));
    }

    @Override
    public void saveCategory(Category category) {
        log.info("Incoming data: {}", categoryRepository.save(category));
    }

    @Override
    public void updateCategory(Long categoryId, Category category) {
        Category fetchedCategory = readCategory(categoryId);
        log.info("Before Updating data: {}", fetchedCategory);
        fetchedCategory.setName(category.getName());
        fetchedCategory.setDescription(category.getDescription());
        log.info("updated data: {}",categoryRepository.save(fetchedCategory));
    }

}
