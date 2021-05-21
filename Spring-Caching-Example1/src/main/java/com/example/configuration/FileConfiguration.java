package com.example.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "file.properties")
public class FileConfiguration {

	/**
	 * https://stackabuse.com/spring-boot-configuring-properties/#:~:text=Java%20and%20XML%2Dbased%20property,By%20default%2C%20the%20application.
	 * 
	 * 
	 * https://www.baeldung.com/properties-with-spring
	 * 
	 * 
	 */

	@Value("${file.path}")
	private String filePath;
	@Value("${file.path-common}")
	private String commonFilePath;

	public String getFilePath() {
		return filePath;
	}

	public String getCommonFilePath() {
		return commonFilePath;
	}

}
