package me.m11m.p1907;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableCaching
@EnableScheduling
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@CacheEvict(allEntries = true, cacheNames = { "kakaoBookApi" })
	@Scheduled(fixedDelay = 30000)
	public void cacheEvictKakao() {
		//30초마다 카카오 API 캐시 제거

	}

	@CacheEvict(allEntries = true, cacheNames = { "countGroupBy" })
	@Scheduled(fixedDelay = 2000)
	public void cacheEvictSearchCount() {
		//2초마다 검색 쿼리 캐시 초기화
	}
}
