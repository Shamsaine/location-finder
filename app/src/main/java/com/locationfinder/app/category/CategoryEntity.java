package com.locationfinder.app.category;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.locationfinder.app.location.LocationEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "category")
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Integer categoryId;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "parent_id", referencedColumnName = "category_id")
    private CategoryEntity parentCategory;

    @OneToMany(mappedBy = "parentCategory", cascade = CascadeType.ALL)
    private List<CategoryEntity> subCategories;

    @OneToMany(mappedBy = "category")
    @JsonIgnore // Prevent circular reference during serialization
    private List<LocationEntity> locations;

    // Constructors
    public CategoryEntity() {
    }

    public CategoryEntity(String name, CategoryEntity parentCategory) {
        this.name = name;
        this.parentCategory = parentCategory;
    }

    // Getters and Setters
    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryEntity getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(CategoryEntity parentCategory) {
        this.parentCategory = parentCategory;
    }

    public List<CategoryEntity> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(List<CategoryEntity> subCategories) {
        this.subCategories = subCategories;
    }

    public List<LocationEntity> getLocations() {
        return locations;
    }

    public void setLocations(List<LocationEntity> locations) {
        this.locations = locations;
    }

    @Override
    public String toString() {
        return "CategoryEntity{" +
                "categoryId=" + categoryId +
                ", name='" + name + '\'' +
                ", parentCategory=" + (parentCategory != null ? parentCategory.getCategoryId() : null) +
                '}';
    }
}