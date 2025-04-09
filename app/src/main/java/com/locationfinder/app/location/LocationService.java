package com.locationfinder.app.location;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.locationfinder.app.user.UserEntity;
import com.locationfinder.app.user.UserRepository;

@Service
public class LocationService {

    private final LocationRepository locationRepository;
    private final UserRepository userRepository;

    public LocationService(LocationRepository locationRepository, UserRepository userRepository) {
        this.locationRepository = locationRepository;
        this.userRepository = userRepository;
    }

    // Create or Update a Location
    public LocationEntity saveLocation(LocationEntity location) {
        // Ensure the description is handled properly
        if (location.getDescription() == null || location.getDescription().isEmpty()) {
            location.setDescription("No description provided.");
        }

        // Attach the user to the location
        if (location.getCreatedBy() != null && location.getCreatedBy().getId() != null) {
            Optional<UserEntity> user = userRepository.findById(location.getCreatedBy().getId());
            user.ifPresent(location::setCreatedBy);
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

    // Update a Location
    public LocationEntity updateLocation(Integer id, LocationEntity updatedLocation) {
        return locationRepository.findById(id).map(existingLocation -> {
            // Update fields
            existingLocation.setName(updatedLocation.getName());
            existingLocation.setAddress(updatedLocation.getAddress());
            existingLocation.setLongitude(updatedLocation.getLongitude());
            existingLocation.setLatitude(updatedLocation.getLatitude());
            existingLocation.setOpeningHours(updatedLocation.getOpeningHours());
            existingLocation.setClosingHours(updatedLocation.getClosingHours());
            existingLocation.setDescription(updatedLocation.getDescription());

            // Update category if provided
            if (updatedLocation.getCategory() != null && updatedLocation.getCategory().getCategoryId() != null) {
                existingLocation.setCategory(updatedLocation.getCategory());
            }

            // Update createdBy if provided
            if (updatedLocation.getCreatedBy() != null && updatedLocation.getCreatedBy().getId() != null) {
                Optional<UserEntity> user = userRepository.findById(updatedLocation.getCreatedBy().getId());
                user.ifPresent(existingLocation::setCreatedBy);
            }

            // Update timestamps
            existingLocation.setUpdatedAt(LocalDateTime.now());

            return locationRepository.save(existingLocation);
        }).orElseThrow(() -> new RuntimeException("Location not found with ID: " + id));
    }
}