package com.adwitiya.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adwitiya.model.User;
import com.adwitiya.repository.UserDaoImplementation;

@Service
public class UserServiceImplementation implements UserService {
	
	@Autowired
	private UserDaoImplementation userDao;

	@Override
	public User getUserById(Long userId) {

		return userDao.getUserById(userId);
	}

	@Override
	public User getUserByEmail(String email) {
		
		return userDao.getUserByEmail(email);
	}

	@Override
	public User createUser(User user) {
		
		return userDao.registerUser(user);
	}

}
