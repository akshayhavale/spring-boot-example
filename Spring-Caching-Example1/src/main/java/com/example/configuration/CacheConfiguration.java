package com.example.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
/**
 * 
 * @author akshayhavale
 *
 *https://www.baeldung.com/spring-cache-tutorial
 */
@Configuration
@EnableCaching
@EnableScheduling
public class CacheConfiguration {
	
	private static final Logger logger = LoggerFactory.getLogger(CacheConfiguration.class);

	@Bean
	public CacheManager cacheManager() {
		return new ConcurrentMapCacheManager("users");
	}
	
	@Scheduled(initialDelay = 20000,fixedDelay = 20000)
	@CacheEvict(value="users", allEntries=true)
	public void deleteAllUsersFromCache() {
		logger.info("deleted all users from cache");
	}

}
