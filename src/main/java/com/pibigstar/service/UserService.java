package com.pibigstar.service;

import java.util.List;

import com.pibigstar.domain.User;

public interface UserService {
	
	public List<User> findAll();
	
	public User get(Long id);
	
	public int update(User user);
	
	public int add(User user);

	public int delete(Long id);
}
