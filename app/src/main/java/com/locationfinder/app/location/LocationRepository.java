package com.locationfinder.app.location;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<LocationEntity, Integer> {

    // Custom query to find locations by name or category name (case-insensitive)
    List<LocationEntity> findByNameContainingIgnoreCaseOrCategory_NameContainingIgnoreCase(String name, String categoryName);
}