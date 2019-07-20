package me.m11m.p1907.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import me.m11m.p1907.model.Sample;
import me.m11m.p1907.service.SampleService;
import springfox.documentation.annotations.ApiIgnore;

/**
 * SampleController
 */
@ApiIgnore
@RestController
public class SampleController {
    @Autowired
	SampleService samplService;

    @GetMapping("/samples")
	ResponseEntity<List<Sample>> getAllToDos() {
        return new ResponseEntity<>(samplService.findAll(), HttpStatus.OK);
    }
}