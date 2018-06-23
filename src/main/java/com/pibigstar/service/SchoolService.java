package com.pibigstar.service;

import java.util.List;

import com.pibigstar.domain.School;

public interface SchoolService {
	
	public List<School> findAll();
	
	public School getOneById(Long id);
	
	public List<School> findAllLikeName(String name);
	
	public int delete(Long id);
	
	public int update(School school);
	
	public int add(School school);
	
}
