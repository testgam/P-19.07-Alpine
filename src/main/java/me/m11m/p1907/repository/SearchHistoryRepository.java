package me.m11m.p1907.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import me.m11m.p1907.model.SearchHistory;
import me.m11m.p1907.model.SearchStatDTO;

/**
 * SearchHistoryRepository
 * 
 */
@Repository
public interface SearchHistoryRepository extends JpaRepository<SearchHistory, Long> {
    public List<SearchHistory> findByUserIdOrderByCreateDateTimeDesc(String userId);
    
    
    /* SearchHistoryRepositorySupport.countGroupByKeywordOrderByCount() 를 사용하세요 */
    @Deprecated
    @Query("select new me.m11m.p1907.model.SearchStatDTO(s.keyword, COUNT(s.keyword)) from SearchHistory s group by s.keyword order by 2 DESC")
    public List<SearchStatDTO> countGroupByKeywordOrderByCount(Pageable pageable);
}