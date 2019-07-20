package me.m11m.p1907.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import me.m11m.p1907.model.Sample;
import me.m11m.p1907.repository.SampleRepository;

/**
 * SampleServiceTest
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class SampleServiceTest {

    @Autowired
    SampleRepository sampleRepository;

    @Test
    public void getAllSamples(){
        
        Sample s = Sample.builder().id(1L).text("안뇽1").build();
        // when(sampleRepository.save(any(Sample.class))).thenReturn(s);

        sampleRepository.save(s);
        
        SampleService sampleService = new SampleService(sampleRepository);

        List<Sample> l = sampleService.findAll();


        Sample last = l.get(l.size()-1);
        
        assertEquals(s.getId(), last.getId());
        assertEquals(s.getText(), last.getText());
    }
    
}