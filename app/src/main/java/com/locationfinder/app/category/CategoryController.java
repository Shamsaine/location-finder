package com.locationfinder.app.category;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    // Create or update a category
    @PostMapping
    public ResponseEntity<CategoryEntity> saveCategory(@RequestBody CategoryEntity category) {
        CategoryEntity savedCategory = categoryService.saveCategory(category);
        return ResponseEntity.ok(savedCategory);
    }

    // Retrieve all categories
    @GetMapping
    public ResponseEntity<List<CategoryEntity>> getAllCategories() {
        List<CategoryEntity> categories = categoryService.getAllCategories();
        return ResponseEntity.ok(categories);
    }

    // Retrieve a category by ID
    @GetMapping("/{id}")
    public ResponseEntity<CategoryEntity> getCategoryById(@PathVariable Integer id) {
        Optional<CategoryEntity> category = categoryService.getCategoryById(id);
        return category.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Retrieve subcategories of a given parent category
    @GetMapping("/{id}/subcategories")
    public ResponseEntity<List<CategoryEntity>> getSubCategories(@PathVariable Integer id) {
        List<CategoryEntity> subCategories = categoryService.getSubCategories(id);
        return ResponseEntity.ok(subCategories);
    }

    // Search categories by name
    @GetMapping("/search")
    public ResponseEntity<List<CategoryEntity>> searchCategoriesByName(@RequestParam String name) {
        List<CategoryEntity> categories = categoryService.searchCategoriesByName(name);
        return ResponseEntity.ok(categories);
    }

    // Delete a category by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategoryById(@PathVariable Integer id) {
        categoryService.deleteCategoryById(id);
        return ResponseEntity.noContent().build();
    }
}