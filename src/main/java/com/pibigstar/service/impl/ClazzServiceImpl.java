package com.pibigstar.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pibigstar.dao.ClazzMapper;
import com.pibigstar.domain.Clazz;
import com.pibigstar.service.ClazzService;

@Service
public class ClazzServiceImpl implements ClazzService{

	@Autowired
	private ClazzMapper clazzMapper;
	
	@Override
	public Clazz getOneById(Long id) {
		return clazzMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Clazz> list() {
		return clazzMapper.findAll();
	}

	@Transactional
	@Override
	public int add(Clazz clazz) {
		return clazzMapper.insert(clazz);
	}

	@Transactional
	@Override
	public int delete(Long id) {
		return clazzMapper.deleteByPrimaryKey(id);
	}

	@Transactional
	@Override
	public int update(Clazz clazz) {
		return clazzMapper.updateByPrimaryKeySelective(clazz);
	}

}
