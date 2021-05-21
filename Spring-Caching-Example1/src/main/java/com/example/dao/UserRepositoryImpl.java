package com.example.dao;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import com.example.configuration.FileConfiguration;
import com.example.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

@Service
public class UserRepositoryImpl implements UserRepository {

	private static final Logger logger = LoggerFactory.getLogger(UserRepositoryImpl.class);

	@Autowired
	private FileConfiguration configuration;

	@Autowired
	private ResourceLoader resourceLoader;

	private List<User> users = new ArrayList<User>();

	@Override
	public List<User> findAll() {
		return users;
	}

	/**
	 * 
	 * https://mkyong.com/java/java-read-a-file-from-resources-folder/
	 */

	@PostConstruct
	public void initializeUsers() throws IOException {
		/**
		 * Type 1 to fetch file from resource
		 */
		Resource resource = resourceLoader.getResource(configuration.getFilePath());
		File file1 = resource.getFile();
		if (file1 == null) {
			logger.info("File can't fetch from file location like:- classpath:/resources/files/user.json");
		} else {
			logger.info("File fetched from file location like:- classpath:/resources/files/user.json");
		}

		/**
		 * Type 2 to fetch file from resource
		 */
		File file2 = new File(this.getClass().getResource(configuration.getCommonFilePath()).getFile());

		if (file2 == null) {
			logger.info("File can't fetch from file location like:- /files/user.json");
		} else {
			logger.info("File fetched from file location like:- /files/user.json");
		}

		List<User> list = null;
		if (users.isEmpty()) {
			ObjectMapper mapper = new ObjectMapper();
			CollectionType listType = mapper.getTypeFactory().constructCollectionType(ArrayList.class, User.class);
			list = mapper.readValue(file2, listType);
		}

		if (list == null) {
			logger.warn("Can't able fetch user list and set also");
		}
		this.users = list;
	}

}
