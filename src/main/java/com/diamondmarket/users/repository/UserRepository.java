package com.diamondmarket.users.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.diamondmarket.users.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

	User findByUsername(String username);

}
