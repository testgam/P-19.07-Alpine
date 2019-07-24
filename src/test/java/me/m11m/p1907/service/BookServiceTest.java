package me.m11m.p1907.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import me.m11m.p1907.model.KDocument;

/**
 * BookServiceTest
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class BookServiceTest {
    
    
    
    @Test
    // @Ignore("not yet")
    public void testKakaoAPI(){
        RestTemplate rest =  new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "KakaoAK "+"62964ac7891e18fc1292b855dc88c379");
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<KDocument> result = rest.exchange("https://dapi.kakao.com/v3/search/book?query=my",
                HttpMethod.GET,
                entity, KDocument.class);

        System.out.println("############################"+ result.getBody());

    }
    
}