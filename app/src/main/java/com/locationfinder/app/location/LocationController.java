package com.locationfinder.app.location;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/locations")
public class LocationController {

    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    // Create or Update a Location
    @PostMapping
    public ResponseEntity<LocationEntity> saveLocation(@RequestBody LocationEntity location) {
        LocationEntity savedLocation = locationService.saveLocation(location);
        return ResponseEntity.ok(savedLocation);
    }

    // Retrieve all Locations
    @GetMapping
    public ResponseEntity<List<LocationEntity>> getAllLocations() {
        List<LocationEntity> locations = locationService.getAllLocations();
        return ResponseEntity.ok(locations);
    }

    // Retrieve a Location by ID
    @GetMapping("/{id}")
    public ResponseEntity<LocationEntity> getLocationById(@PathVariable Integer id) {
        Optional<LocationEntity> location = locationService.getLocationById(id);
        return location.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update a Location by ID
    @PutMapping("/{id}")
    public ResponseEntity<LocationEntity> updateLocation(@PathVariable Integer id, @RequestBody LocationEntity updatedLocation) {
        Optional<LocationEntity> existingLocation = locationService.getLocationById(id);

        if (existingLocation.isPresent()) {
            LocationEntity savedLocation = locationService.updateLocation(id, updatedLocation);
            return ResponseEntity.ok(savedLocation);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a Location by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLocationById(@PathVariable Integer id) {
        locationService.deleteLocationById(id);
        return ResponseEntity.noContent().build();
    }

    // Search Locations by Name or Category
    @GetMapping("/search")
    public ResponseEntity<List<LocationEntity>> searchLocations(@RequestParam String query) {
        List<LocationEntity> results = locationService.searchLocations(query);
        return ResponseEntity.ok(results);
    }
}