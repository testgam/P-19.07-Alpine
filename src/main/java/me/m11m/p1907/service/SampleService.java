package me.m11m.p1907.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import me.m11m.p1907.model.Sample;
import me.m11m.p1907.repository.SampleRepository;

/**
 * SampleService
 */
@Service
public class SampleService {

    SampleRepository sampleRepository;

    public SampleService(SampleRepository sampleRepository){
        this.sampleRepository = sampleRepository;
    }

    public List<Sample> findAll(){
        return sampleRepository.findAll();
    }
}