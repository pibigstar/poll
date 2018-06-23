package com.pibigstar.service;

import java.util.List;

import com.pibigstar.domain.Course;

public interface CourseService {
	
	public List<Course> findAll();
	
	public Course getOneById(Long id);
	
	public List<Course> findAllLikeName(String name);
	
	public int update(Course course);
	
	public int delete(Long id);
	
	public int add(Course course);

}
