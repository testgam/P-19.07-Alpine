package me.m11m.p1907.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.m11m.p1907.model.SearchHistory;
import me.m11m.p1907.model.SearchStatDTO;
import me.m11m.p1907.repository.SearchHistoryRepository;
import me.m11m.p1907.repository.SearchHistoryRepositorySupport;

/**
 * SearchHistoryService
 */
@Service
public class SearchHistoryService {

    @Autowired
    SearchHistoryRepository searchHistoryRepository;
    
    @Autowired
    SearchHistoryRepositorySupport searchHistoryRepositorySupport;

    public SearchHistory addAHistory(SearchHistory s){
        return searchHistoryRepository.save(s);
    }

    public List<SearchHistory> getListByUserId(String userId){
        return searchHistoryRepository.findByUserIdOrderByCreateDateTimeDesc(userId);
    }

    public List<SearchStatDTO> getCountGroupByKeyword(){
        return searchHistoryRepositorySupport.countGroupByKeywordOrderByCount();
    }

    
    
}