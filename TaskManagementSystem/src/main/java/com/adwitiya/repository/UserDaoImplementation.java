package com.adwitiya.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.adwitiya.model.User;

@Repository
public class UserDaoImplementation implements UserDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public User registerUser(User user) {
		String query = "insert into users (email, password) values (?, ?)";
		jdbcTemplate.update(query, user.getEmail(), user.getPassword());
		
		return user; 
	}

	@Override
	public User getUserById(Long userId) {
		String query = "select * from users where id = ?";
		
		return jdbcTemplate.queryForObject(query, new Object[] {userId}, new UserRowMapper());
	}

	@Override
	public User getUserByEmail(String email) {
		String query = "select * from users where email = ?";
		
		return jdbcTemplate.queryForObject(query, new Object[] {email}, new UserRowMapper());
	}

}
