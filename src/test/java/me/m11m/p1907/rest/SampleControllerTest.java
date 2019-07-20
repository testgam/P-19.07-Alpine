package me.m11m.p1907.rest;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import me.m11m.p1907.model.Sample;
import me.m11m.p1907.service.SampleService;

/**
 * TestController
 */
@WebMvcTest
@RunWith(SpringRunner.class)
public class SampleControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    SampleService sampleService;

    @Test
    public void getAllDatas() throws Exception {
        List<Sample> l = new ArrayList<>();
        l.add(Sample.builder().id(1).text("A").build());
        l.add(Sample.builder().id(2).text("B").build());

        when(sampleService.findAll()).thenReturn(l);

        mockMvc.perform(get("/samples").accept(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$", hasSize(2)))
            .andExpect(jsonPath("$.[0].text", is("A")))
            .andExpect(jsonPath("$.[1].text", is("B")))
            .andDo(print());
    }

}