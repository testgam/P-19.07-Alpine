package me.m11m.p1907.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.m11m.p1907.model.SearchHistory;

/**
 * SearchHistoryRepository
 */
@Repository
public interface SearchHistoryRepository extends JpaRepository<SearchHistory, Long> {
    public List<SearchHistory> findByUserId(String userId);
}