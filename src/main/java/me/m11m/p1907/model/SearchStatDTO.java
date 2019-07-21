package me.m11m.p1907.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * SearchStatDTO
 */
@Data
@NoArgsConstructor
public class SearchStatDTO {

    @Builder
    public SearchStatDTO(String keyword, Long count){
        this.keyword = keyword;
        this.count = count;
    }
    
    String keyword;
    Long count;
    
}