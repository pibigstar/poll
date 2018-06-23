package com.pibigstar.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pibigstar.dao.GradeMapper;
import com.pibigstar.domain.Grade;
import com.pibigstar.service.GradeService;

@Service
public class GradeServiceImpl implements GradeService{

	@Autowired
	private GradeMapper gradeMapper;
	
	@Override
	public Grade getOneById(Long id) {
		return gradeMapper.selectByPrimaryKey(id);
	}

	@Override
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
