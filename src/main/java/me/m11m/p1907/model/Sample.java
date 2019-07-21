package me.m11m.p1907.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * SampleEntity
 */
@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Sample {

    @Id
    @GeneratedValue
    private long id;
    
    private String text;
    
}