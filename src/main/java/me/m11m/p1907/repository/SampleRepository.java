package me.m11m.p1907.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.m11m.p1907.model.Sample;

/**
 * SampleRepository
 */
@Repository("sampleRepository")
public interface SampleRepository extends JpaRepository<Sample, Long> {
}