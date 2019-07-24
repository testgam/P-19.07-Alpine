package me.m11m.p1907.repository;

import static me.m11m.p1907.model.QSearchHistory.searchHistory;

import java.util.List;
import java.util.stream.Collectors;

import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import me.m11m.p1907.model.SearchHistory;
import me.m11m.p1907.model.SearchStatDTO;

/**
 * SearchHistoryRepositorySupport
 */
@Repository
public class SearchHistoryRepositorySupport extends QuerydslRepositorySupport{

    private final JPAQueryFactory queryFactory;

    public SearchHistoryRepositorySupport(JPAQueryFactory queryFactory) {
        super(SearchHistory.class);
        this.queryFactory = queryFactory;
    }

    @Cacheable("countGroupBy")
    public List<SearchStatDTO> countGroupByKeywordOrderByCount(){
        List<Tuple> fetch = queryFactory.selectFrom(searchHistory)
        .select(searchHistory.keyword, searchHistory.keyword.count())
        .groupBy(searchHistory.keyword)
        .orderBy(searchHistory.keyword.count().desc())
        .limit(10).fetch();

        return fetch.stream()
            .map(i -> SearchStatDTO.builder().keyword(i.get(searchHistory.keyword)).count(i.get(searchHistory.keyword.count())).build())
            .collect(Collectors.toList());
                
    }
    
}