package me.m11m.p1907.service;

import static org.junit.Assert.assertEquals;
// import static org.mockito.ArgumentMatchers.any;
// import static org.mockito.Mockito.when;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.boot.test.mock.mockito.MockBean;
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

    @After
    public void clear(){
        // 각 테스트 별로 독립적으로 실행하기 위함. 일종의 보상 쿼리.
        sampleRepository.deleteAll();
    }

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

    @Test
    public void saveASample(){
        // Arrange
        Sample s = Sample.builder().text("안뇽2").build();

        SampleService sampleService = new SampleService(sampleRepository);

        // Act
        sampleService.save(s);

        // Assert
        assertThat(sampleRepository.count(), is(1L));


    }
    
}