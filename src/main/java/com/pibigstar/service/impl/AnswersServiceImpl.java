package com.pibigstar.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pibigstar.dao.AnswersMapper;
import com.pibigstar.domain.Answers;
import com.pibigstar.domain.AnswersWithBLOBs;
import com.pibigstar.service.AnswersService;

@Service
public class AnswersServiceImpl implements AnswersService{

	@Autowired
	private AnswersMapper answersMapper;
	
	@Override
	public Answers get(Long id) {
		return answersMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Answers> findAll() {
		return answersMapper.findAll();
	}

	@Transactional
	@Override
	public int update(AnswersWithBLOBs answers) {
		return answersMapper.updateByPrimaryKeySelective(answers);
	}

	@Transactional
	@Override
	public int delete(Long id) {
		return answersMapper.deleteByPrimaryKey(id);
	}

	@Transactional
	@Override
	public int add(AnswersWithBLOBs answers) {
		
		return answersMapper.insert(answers);
	}

}
