package me.m11m.p1907.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * SearchHistory
 */
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SearchHistory {

    @Id
    @GeneratedValue
    @JsonIgnore
    long id;

    String userId;
    String searchKeyword;

    @CreationTimestamp
    private LocalDateTime createDateTime;
}