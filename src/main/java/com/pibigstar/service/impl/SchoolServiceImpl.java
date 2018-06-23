package com.pibigstar.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.pibigstar.dao.SchoolMapper;
import com.pibigstar.domain.School;
import com.pibigstar.service.SchoolService;

@Service
@CacheConfig(cacheNames="school")
public class SchoolServiceImpl implements SchoolService{

	@Autowired
	private SchoolMapper schoolMapper;
	
	@Override
	public List<School> findAll() {
		return schoolMapper.findAll();
	}

	@Override
	public School getOneById(Long id) {
		return schoolMapper.selectByPrimaryKey(id);
	}

	@Override
	@Cacheable
	public List<School> findAllLikeName(String name) {
		return 	schoolMapper.findAllLikeName("%"+name+"%");
	}

	@Transactional
	@Override
	public int delete(Long id) {
		return schoolMapper.deleteByPrimaryKey(id);
	}

	@Transactional
	@Override
	public int update(School school) {
		return schoolMapper.updateByPrimaryKeySelective(school);
	}

	@Transactional
	@Override
	public int add(School school) {
		return schoolMapper.insert(school);
	}

}
