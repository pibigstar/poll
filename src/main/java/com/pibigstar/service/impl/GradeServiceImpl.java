package com.pibigstar.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.pibigstar.dao.GradeMapper;
import com.pibigstar.domain.Grade;
import com.pibigstar.service.GradeService;

@Service
@CacheConfig(cacheNames="grades")
public class GradeServiceImpl implements GradeService{

	@Autowired
	private GradeMapper gradeMapper;
	
	@Override
	@Cacheable
	public Grade getOneById(Long id) {
		return gradeMapper.selectByPrimaryKey(id);
	}

	@Override
	@Cacheable
	public List<Grade> list() {
		return gradeMapper.findAll();
	}

	@Transactional
	@Override
	public int add(Grade grade) {
		int result = gradeMapper.insert(grade);
		return result;
	}

	@Transactional
	@Override
	public int delete(Long id) {
		return gradeMapper.deleteByPrimaryKey(id);
	}

	@Transactional
	@Override
	public int update(Grade grade) {
		return gradeMapper.updateByPrimaryKeySelective(grade);
	}

}
