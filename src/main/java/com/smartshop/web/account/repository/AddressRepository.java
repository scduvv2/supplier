package com.smartshop.web.account.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.smartshop.web.account.Address;

@Repository
public interface AddressRepository  extends MongoRepository<Address, String>{


}
