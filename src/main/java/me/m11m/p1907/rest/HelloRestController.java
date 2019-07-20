package me.m11m.p1907.rest;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.annotations.ApiIgnore;

/**
 * HelloRestController
 */
@RestController
public class HelloRestController {

	@RequestMapping(value = "/")
	@ApiIgnore
	public void redirectToSwagger(HttpServletResponse response) throws IOException {
		response.sendRedirect("/swagger-ui.html");
	}

	@GetMapping("/helloworld")
	public String helloWorld(){
		return "helloWorld";
	}
    
}