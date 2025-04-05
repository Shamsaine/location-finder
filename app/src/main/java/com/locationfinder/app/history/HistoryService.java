package com.locationfinder.app.history;

import com.locationfinder.app.user.UserEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class HistoryService {

    private final HistoryRepository historyRepository;

    public HistoryService(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }

    public void saveSearchHistory(UserEntity user, String searchQuery) {
        HistoryEntity history = new HistoryEntity();
        history.setUser(user);
        history.setSearchQuery(searchQuery);
        history.setSearchedAt(LocalDateTime.now());
        historyRepository.save(history);
    }
}