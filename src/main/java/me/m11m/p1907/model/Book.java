package me.m11m.p1907.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Book
 * 제목, 도서 썸네일, 소개, ISBN, 저자, 출판사, 출판일, 정가, 판매가 필수
 */
// @Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Book{
    
    @JsonIgnore
    long id;
    
    String title;
    String thumbnail;
    String contents;
    String isbn;
    List<String> authors;
    String publisher;
    String datetime;
    Integer price;
    Integer salePrice;

    

}