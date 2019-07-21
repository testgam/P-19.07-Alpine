package me.m11m.p1907;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import me.m11m.p1907.model.Sample;
import me.m11m.p1907.repository.SampleRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	/* @Bean
	public ApplicationRunner setup(SampleRepository sampleRepository){
		return (args) ->{
			sampleRepository.save(Sample.builder().text("hello1").build());
			sampleRepository.save(Sample.builder().text("hello2").build());
			sampleRepository.save(Sample.builder().text("hello3").build());
			sampleRepository.save(Sample.builder().text("hello4").build());
		};
	} */

}
