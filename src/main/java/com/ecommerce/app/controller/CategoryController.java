package com.ecommerce.app.controller;

import com.ecommerce.app.entity.Category;
import com.ecommerce.app.service.dao.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = "/")
    public ResponseEntity<List<Category>> getAllCategories(){
        List<Category> categories = categoryService.getAllCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable(value = "categoryId") Long categoryId){
        Category category = categoryService.getCategoryById(categoryId);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @PostMapping(value = "/")
    public ResponseEntity<List<Category>> saveAllCategories(@RequestBody List<Category> categories){
        List<Category> savedCategories = categoryService.saveAllCategories(categories);
        return new ResponseEntity<>(savedCategories, HttpStatus.OK);
    }
    @PostMapping(value = "/saveCategory")
    public ResponseEntity<Category> saveCategory(@RequestBody Category category){
        Category savedCategory = categoryService.saveCategory(category);
        return new ResponseEntity<>(savedCategory, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable(value = "id") Long categoryId, @RequestBody Category category) {
        Category savedCategory = categoryService.updateCategory(categoryId, category);

        return new ResponseEntity<>(savedCategory, HttpStatus.OK);
    }
}
