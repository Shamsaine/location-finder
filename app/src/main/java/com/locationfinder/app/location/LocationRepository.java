package com.locationfinder.app.location;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<LocationEntity, Integer> {

    // Custom query to find locations by name or category name (case-insensitive)
    List<LocationEntity> findByNameContainingIgnoreCaseOrCategory_NameContainingIgnoreCase(String name, String categoryName);
}