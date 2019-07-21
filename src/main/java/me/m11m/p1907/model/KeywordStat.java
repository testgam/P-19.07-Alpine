package me.m11m.p1907.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * KeywordStat
 */
// @Entity
// @Table(name="keywordstat")
// @Data
// @NoArgsConstructor
public class KeywordStat {

    @Id
    @GeneratedValue
    Long id;

    @Column(unique = true)
    String keyword;

    int size;

    @JsonIgnore
    @OneToMany(mappedBy = "keywordStat", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<SearchHistory> histories = new ArrayList<>();
    
}