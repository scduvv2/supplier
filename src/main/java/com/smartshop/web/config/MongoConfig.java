package com.smartshop.web.config;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.data.mongodb.core.MongoFactoryBean;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import com.mongodb.Mongo;
import com.smartshop.web.account.repository.AccountRepository;

@Configuration

public class MongoConfig{

	public @Bean MongoTemplate mongoTemplate(Mongo mongo) {
		MongoTemplate mongoTemplate = new MongoTemplate(mongo, "supplier");
		return mongoTemplate;
	}
	


	/*
	 * Factory bean that creates the Mongo instance
	 */
	public @Bean MongoFactoryBean mongo() {
		MongoFactoryBean mongo = new MongoFactoryBean();
		mongo.setHost("192.168.1.14");
		return mongo;
	}


	@Bean
	public AccountRepository accountRepository(){
		
		return	new AccountRepository();
	}

}
