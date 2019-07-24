package me.m11m.p1907.repository;

import java.util.List;

import com.querydsl.jpa.impl.JPAQueryFactory;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import me.m11m.p1907.model.SearchHistory;
import static me.m11m.p1907.model.QSearchHistory.searchHistory;

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
    
    public List<SearchHistory> findByName(String keyword) {
        return queryFactory
                .selectFrom(searchHistory)
                .where(searchHistory.keyword.eq(keyword))
                .fetch();
    }
    
}