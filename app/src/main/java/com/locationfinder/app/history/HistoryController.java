package com.locationfinder.app.history;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/history")
public class HistoryController {

    private final HistoryRepository historyRepository;

    public HistoryController(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }

    @GetMapping
    public List<HistoryEntity> getSearchHistory(@RequestParam Integer userId) {
        return historyRepository.findByUserId(userId);
    }
}