package com.adwitiya.repository;

import com.adwitiya.model.User;

public interface UserDao {
	
	public User registerUser(User user);

	public User getUserById(Long userId);
	
	public User getUserByEmail(String email);
}
