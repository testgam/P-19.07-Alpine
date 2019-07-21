package me.m11m.p1907.service;

import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import me.m11m.p1907.model.SearchHistory;
import me.m11m.p1907.repository.SearchHistoryRepository;

import static org.hamcrest.Matchers.*;

/**
 * SearchHistoryServiceTest
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class SearchHistoryServiceTest {

    @Autowired
    SearchHistoryRepository searchHistoryRepository;
    
    @Test
    /**
     * 서치 이력 추가 검증
     */
    public void testSuccessAddASearchHistory(){
        // Arrange
        SearchHistory searchHistory = SearchHistory.builder().userId("USERID001").searchKeyword("HELLO").build();
        
        // Act
        long id = searchHistoryRepository.save(searchHistory).getId();

        // Assert
        assertThat(searchHistoryRepository.findByUserId("USERID001").get(0).getId(), is(id));

    }
}