package com.ecommerce.app.service;

import com.ecommerce.app.entity.Category;
import com.ecommerce.app.exceptions.CategoryNotFoundException;
import com.ecommerce.app.repository.CategoryRepository;
import com.ecommerce.app.service.dao.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Category readCategory(Long categoryId){
        Optional<Category> optionalCategory = categoryRepository.findById(categoryId);
        if(!optionalCategory.isPresent()) {
            throw new CategoryNotFoundException("Invalid category or not present" + categoryId);
        }
        log.info("Retrieved Data: {}", optionalCategory.get());
        return optionalCategory.get();
    }

    @Override
    public void saveCategory(Category category) {
        log.info("Incoming data: {}", categoryRepository.save(category));
    }

    @Override
    public void updateCategory(Long categoryId, Category category) {
        Category fetchedCategory = categoryRepository.findById(categoryId).get();
        log.info("Before Updating data: {}", fetchedCategory);
        fetchedCategory.setName(category.getName());
        fetchedCategory.setDescription(category.getDescription());
        log.info("updated data: {}",categoryRepository.save(fetchedCategory));
    }

}
