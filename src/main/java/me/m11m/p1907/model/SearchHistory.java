package me.m11m.p1907.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * SearchHistory
 */
@Entity
@Getter
@NoArgsConstructor
public class SearchHistory {

    @Id
    @GeneratedValue
    @JsonIgnore
    long id;

    // @Column(unique = true)
    String userId;

    String keyword;

    // @ManyToOne
    // @JoinColumn(name = "keywordstat_id")
    // KeywordStat keywordStat;

    @CreationTimestamp
    private LocalDateTime createDateTime;

    @Builder
    public SearchHistory(String userId, String keyword){
        this.userId=userId;
        this.keyword=keyword;
    }
}