package com.smartshop.web.config;

import org.springframework.context.annotation.*;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.repository.RepositoryDefinition;

import com.smartshop.web.account.dao.AccountDetailsDao;
import com.smartshop.web.account.dao.CatalogDao;
import com.smartshop.web.account.dao.StoreDao;

@Configuration
@ComponentScan(basePackages = { "com.smartshop" })

public class RootConfig {
	
	@Bean
	public static PropertyPlaceholderConfigurer propertyPlaceholderConfigurer() {
		PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
		ppc.setLocation(new ClassPathResource("/persistence.properties"));
		return ppc;
	}
	
	public @Bean AccountDetailsDao accountDetailsDao(){
		
		AccountDetailsDao accountDetailsDao = new AccountDetailsDao();
		
		return accountDetailsDao;
	}

	public @Bean CatalogDao catalogDao(){
		return new CatalogDao();
	}
	
	public @Bean StoreDao storeDao(){
		return new StoreDao();
	}
}