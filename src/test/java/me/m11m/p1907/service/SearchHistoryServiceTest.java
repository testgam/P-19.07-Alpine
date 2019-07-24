package me.m11m.p1907.service;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import me.m11m.p1907.model.SearchHistory;
import me.m11m.p1907.model.SearchStatDTO;
import me.m11m.p1907.repository.SearchHistoryRepository;

/**
 * SearchHistoryServiceTest
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class SearchHistoryServiceTest {

    @Autowired
    SearchHistoryRepository searchHistoryRepository;
    
    @After
    public void clean(){
        searchHistoryRepository.deleteAll();
    }


    /**
     * 서치 이력 추가 및 조회
     */
    @Test
    public void testSuccessAddASearchHistory(){
        // Arrange
        SearchHistory searchHistory = SearchHistory.builder().userId("USERID001").keyword("HELLO").build();
        
        // Act
        long id = searchHistoryRepository.save(searchHistory).getId();

        // Assert
        assertThat(searchHistoryRepository.findByUserIdOrderByCreateDateTimeDesc("USERID001").get(0).getId(), is(id));
    }


    /**
     * keyword 별 카운트 내림차순 조회
     */
    @Test
    public void testCountGroupByKeywordOrder(){
        // Arrange
        List<SearchHistory> histories = Arrays.asList( SearchHistory.builder().userId("USERID001").keyword("HELLO").build()
        , SearchHistory.builder().userId("USERID001").keyword("HELLO").build()
        ,SearchHistory.builder().userId("USERID003").keyword("HELLO2").build()
        ,SearchHistory.builder().userId("USERID002").keyword("HELLO").build()
        ,SearchHistory.builder().userId("USERID001").keyword("HELLO").build());

        searchHistoryRepository.saveAll(histories);

        // Act
        List<SearchStatDTO> ls = searchHistoryRepository.countGroupByKeywordOrderByCount(PageRequest.of(0,10));

        // Assert
        assertThat(ls.get(0).getCount(), is(4L));
    }

    @Test
    public void countByQClass(){
        /* QueryEntity p = QPersonEntity.person; //the querydsl definition

int age = new JPAQuery(em)
    .select(p.age)
    .from(p)
    .where(p.firstname.eq(firstname).and(p.lastname.eq(lastname)))
    .groupBy(p.age)
    .orderBy(p.age.count().desc())
    .limit(1)
    .fetchOne(); */
    }

  
}