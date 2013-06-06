package com.smartshop.web.account.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.smartshop.web.account.PhoneNumber;

@Repository
public interface PhoneNumberRepository extends MongoRepository<PhoneNumber, String>{
	
	
	public PhoneNumber findByPhoneNumber(Long phoneNumber);

}
