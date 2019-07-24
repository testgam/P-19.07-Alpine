package me.m11m.p1907.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import me.m11m.p1907.model.KDocument;

/**
 * BookService
 */
@Service
public class BookService {

    @Autowired
    RestTemplate restTemplate;

    @Value("${search-api.kakao.url}")
    String searchUrl;

    @Cacheable(value="kakaoBookApi")
    public KDocument findBookByTitle(String keyword, int page){
        // TODO: Hystrix 로 fallback (Naver API) 구성 필요
        KDocument result = restTemplate.getForObject(searchUrl+"?query="+keyword+"&page="+page, KDocument.class);

        return result;
    }
}