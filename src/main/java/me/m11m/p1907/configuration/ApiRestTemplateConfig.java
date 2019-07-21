package me.m11m.p1907.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;

/**
 * ApiRestTemplateConfig
 */
@Configuration
public class ApiRestTemplateConfig {
    
    @Value("${search-api.kakao.key}")
    String kakaoKey;

    @Bean
    @Primary
    public RestTemplate kakaoRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add((request,body,execution)->{
            request.getHeaders().add("Authorization", "KakaoAK "+ kakaoKey);
            return execution.execute(request, body);
        });
        return restTemplate;
    }
    

}