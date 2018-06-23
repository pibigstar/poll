package com.pibigstar.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pibigstar.dao.CourseMapper;
import com.pibigstar.domain.Course;
import com.pibigstar.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService{

	@Autowired
	private CourseMapper courseMapper;
	
	@Override
	public List<Course> findAll() {
		return courseMapper.findAll();
	}

	@Override
	public Course getOneById(Long id) {
		return courseMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Course> findAllLikeName(String name) {
		return courseMapper.findAllLikeName("%"+name+"%");
	}

	@Transactional
	@Override
	public int update(Course course) {
		return courseMapper.updateByPrimaryKeySelective(course);
	}

	@Transactional
	@Override
	public int delete(Long id) {
		return courseMapper.deleteByPrimaryKey(id);
	}

	@Transactional
	@Override
	public int add(Course course) {
		return courseMapper.insert(course);
	}

}
