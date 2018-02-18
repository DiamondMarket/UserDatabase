package com.diamondmarket.users.service;

import com.diamondmarket.users.model.User;

public interface UserService {

	User createUser(User user) throws Exception;

	User getUser(String userId) throws Exception;

	String deleteUser(String userId) throws Exception;

	User updateUser(User user) throws Exception;

	User loginUser(String username, String password) throws Exception;

}
