package com.adwitiya.service;

import com.adwitiya.model.User;

public interface UserService {

	User getUserById(Long userId);
	User getUserByEmail(String email);
	User createUser(User user);
}
