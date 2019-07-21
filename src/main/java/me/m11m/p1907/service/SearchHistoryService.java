package me.m11m.p1907.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import me.m11m.p1907.model.SearchHistory;
import me.m11m.p1907.model.SearchStatDTO;
import me.m11m.p1907.repository.SearchHistoryRepository;

/**
 * SearchHistoryService
 */
@Service
public class SearchHistoryService {

    @Autowired
    SearchHistoryRepository searchHistoryRepository;

    public SearchHistory addAHistory(SearchHistory s){
        return searchHistoryRepository.save(s);
    }

    public List<SearchHistory> getListByUserId(String userId){
        return searchHistoryRepository.findByUserIdOrderByCreateDateTimeDesc(userId);
    }

    public List<SearchStatDTO> getCountGroupByKeyword(){
        return searchHistoryRepository.countGroupByKeywordOrderByCount(PageRequest.of(0,10));
    }

    // 카운트 조회
    
}