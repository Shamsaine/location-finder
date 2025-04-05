package com.locationfinder.app.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {

    // Find all subcategories of a given parent category
    List<CategoryEntity> findByParentCategory(CategoryEntity parentCategory);

    // Find categories by name (case-insensitive)
    List<CategoryEntity> findByNameContainingIgnoreCase(String name);
}