package com.locationfinder.app.location;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class LocationService {

    private final LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    // Create or Update a Location
    public LocationEntity saveLocation(LocationEntity location) {
        // Ensure the description is handled properly
        if (location.getDescription() == null || location.getDescription().isEmpty()) {
            location.setDescription("No description provided.");
        }
        return locationRepository.save(location);
    }

    // Retrieve all Locations
    public List<LocationEntity> getAllLocations() {
        return locationRepository.findAll();
    }

    // Retrieve a Location by ID
    public Optional<LocationEntity> getLocationById(Integer locationId) {
        return locationRepository.findById(locationId);
    }

    // Delete a Location by ID
    public void deleteLocationById(Integer locationId) {
        locationRepository.deleteById(locationId);
    }

    // Search Locations by Name or Category
    public List<LocationEntity> searchLocations(String query) {
        return locationRepository.findByNameContainingIgnoreCaseOrCategory_NameContainingIgnoreCase(query, query);
    }
}