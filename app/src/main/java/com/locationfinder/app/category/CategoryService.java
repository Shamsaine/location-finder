package com.locationfinder.app.category;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    // Create or update a category
    public CategoryEntity saveCategory(CategoryEntity category) {
        return categoryRepository.save(category);
    }

    // Retrieve all categories
    public List<CategoryEntity> getAllCategories() {
        return categoryRepository.findAll();
    }

    // Retrieve a category by ID
    public Optional<CategoryEntity> getCategoryById(Integer categoryId) {
        return categoryRepository.findById(categoryId);
    }

    // Retrieve subcategories of a given parent category
    public List<CategoryEntity> getSubCategories(Integer parentCategoryId) {
        Optional<CategoryEntity> parentCategory = categoryRepository.findById(parentCategoryId);
        return parentCategory.map(categoryRepository::findByParentCategory).orElseThrow(() -> new RuntimeException("Parent category not found"));
    }

    // Search categories by name
    public List<CategoryEntity> searchCategoriesByName(String name) {
        return categoryRepository.findByNameContainingIgnoreCase(name);
    }

    // Delete a category by ID
    public void deleteCategoryById(Integer categoryId) {
        categoryRepository.deleteById(categoryId);
    }
}