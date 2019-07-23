package me.m11m.p1907.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * KDocument ( 카카오 책 검색 API POJO)
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class KDocument {

    @JsonAlias("documents")
    List<Book> books;

    Meta meta;
    /**
     * InnerKDocument
     */
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    static public class Meta {
        @JsonAlias("is_end")
        boolean endTF;
        @JsonAlias("pageable_count")
        int pageableCount;
        @JsonAlias("total_count")
        int totalCount;
    }

}