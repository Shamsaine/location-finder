package com.locationfinder.app.history;

import com.locationfinder.app.history.HistoryService;
import com.locationfinder.app.location.LocationEntity;
import com.locationfinder.app.location.LocationRepository;
import com.locationfinder.app.user.UserEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {

    private final HistoryService historyService;
    private final LocationRepository locationRepository;

    public SearchController(HistoryService historyService, LocationRepository locationRepository) {
        this.historyService = historyService;
        this.locationRepository = locationRepository;
    }

    @PostMapping
    public List<LocationEntity> performSearch(@RequestParam String query, @RequestParam Integer userId) {
        // Simulate fetching the user (in a real app, fetch from the database or session)
        UserEntity user = new UserEntity();
        user.setId(userId);

        // Save the search query to the history
        historyService.saveSearchHistory(user, query);

        // Query the location table for matching results
        List<LocationEntity> results = locationRepository.findByNameContainingIgnoreCaseOrCategory_NameContainingIgnoreCase(query, query);

        // Return the search results
        return results;
    }
}