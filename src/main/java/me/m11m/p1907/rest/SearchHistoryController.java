package me.m11m.p1907.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import me.m11m.p1907.model.SearchHistory;
import me.m11m.p1907.model.SearchStatDTO;
import me.m11m.p1907.service.SearchHistoryService;

/**
 * SearchHistoryController
 */
@RestController
public class SearchHistoryController {
    @Autowired
    SearchHistoryService searchHistoryService;

    // 유저당 검색 히스토리 조회
    @GetMapping("/histories/_/user")
    public ResponseEntity<List<SearchHistory>> getListSearchHistoryPerUser(@RequestParam String userId){
        List<SearchHistory> result = searchHistoryService.getListByUserId(userId);
        
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    //키워드 당 전체 카운트
    @GetMapping("/histories/_/keyword")
    public ResponseEntity<List<SearchStatDTO>> getCountByKeyword(){
        List<SearchStatDTO> results = searchHistoryService.getCountGroupByKeyword();

        return new ResponseEntity<>(results, HttpStatus.OK);
    }

    
}