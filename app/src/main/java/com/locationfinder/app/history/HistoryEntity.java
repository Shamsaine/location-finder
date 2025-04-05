package com.locationfinder.app.history;

import java.time.LocalDateTime;

import com.locationfinder.app.user.UserEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "search_history")
public class HistoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "search_id")
    private Integer searchId;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "iduser", nullable = false)
    private UserEntity user;

    @Column(name = "search_query", columnDefinition = "TEXT", nullable = false)
    private String searchQuery;

    @Column(name = "searched_at", nullable = false)
    private LocalDateTime searchedAt;

    // Constructors
    public HistoryEntity() {
    }

    public HistoryEntity(UserEntity user, String searchQuery, LocalDateTime searchedAt) {
        this.user = user;
        this.searchQuery = searchQuery;
        this.searchedAt = searchedAt;
    }

    // Getters and Setters
    public Integer getSearchId() {
        return searchId;
    }

    public void setSearchId(Integer searchId) {
        this.searchId = searchId;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public String getSearchQuery() {
        return searchQuery;
    }

    public void setSearchQuery(String searchQuery) {
        this.searchQuery = searchQuery;
    }

    public LocalDateTime getSearchedAt() {
        return searchedAt;
    }

    public void setSearchedAt(LocalDateTime searchedAt) {
        this.searchedAt = searchedAt;
    }

    @Override
    public String toString() {
        return "SearchHistoryEntity{" +
                "searchId=" + searchId +
                ", user=" + user +
                ", searchQuery='" + searchQuery + '\'' +
                ", searchedAt=" + searchedAt +
                '}';
    }
}