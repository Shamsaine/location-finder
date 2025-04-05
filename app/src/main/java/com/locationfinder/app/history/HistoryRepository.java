package com.locationfinder.app.history;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoryRepository extends JpaRepository<HistoryEntity, Integer> {

    // Custom query method to find all search history by a specific user
    List<HistoryEntity> findByUserId(Integer userId);
}