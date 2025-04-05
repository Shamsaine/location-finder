package com.locationfinder.app.history;

import com.locationfinder.app.history.HistoryService;
import com.locationfinder.app.user.UserEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/search")
public class SearchController {

    private final HistoryService historyService;

    public SearchController(HistoryService historyService) {
        this.historyService = historyService;
    }

    @PostMapping
    public String performSearch(@RequestParam String query, @RequestParam Integer userId) {
        // Simulate fetching the user (in a real app, fetch from the database or session)
        UserEntity user = new UserEntity();
        user.setId(userId);

        // Save the search query to the history
        historyService.saveSearchHistory(user, query);

        // Perform the actual search logic (e.g., querying a database or API)
        // For now, return a placeholder result
        return "Search results for: " + query;
    }
}