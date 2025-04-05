package com.locationfinder.app.location;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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