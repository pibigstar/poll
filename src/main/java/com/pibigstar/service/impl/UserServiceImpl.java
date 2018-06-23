package com.pibigstar.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pibigstar.dao.UserMapper;
import com.pibigstar.domain.User;
import com.pibigstar.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public List<User> findAll() {
		return userMapper.findAll();
	}

	@Override
	public User get(Long id) {
		return userMapper.selectByPrimaryKey(id);
	}

	@Transactional
	@Override
	public int update(User user) {
		return userMapper.updateByPrimaryKeySelective(user);
	}
	
	@Transactional
	@Override
	public int add(User user) {
		return userMapper.insert(user);
	}

	@Transactional
	@Override
	public int delete(Long id) {
		return userMapper.deleteByPrimaryKey(id);
	}

}
