package me.m11m.p1907.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * WebMvcConfig
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter{
    
    /*
     * 로그인 인증 Interceptor 설정
     * */
    @Autowired
    LoginCheckInterceptor loginCheckInterceptor;
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginCheckInterceptor)
                .addPathPatterns("/*")
                .excludePathPatterns("/login");
    }
 
}