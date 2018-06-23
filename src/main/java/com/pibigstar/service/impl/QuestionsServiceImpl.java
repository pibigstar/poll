package com.pibigstar.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pibigstar.dao.QuestionsMapper;
import com.pibigstar.domain.Questions;
import com.pibigstar.service.QuestionsService;

@Service
public class QuestionsServiceImpl implements QuestionsService{

	@Autowired
	private QuestionsMapper questionsMapper;
	
	@Override
	public List<Questions> findAll() {
		return questionsMapper.findAll();
	}

	@Override
	public Questions get(Long id) {
		return questionsMapper.selectByPrimaryKey(id);
	}

	@Override
	public int update(Questions question) {
		return questionsMapper.updateByPrimaryKeySelective(question);
	}

	@Override
	public int add(Questions question) {
		return questionsMapper.insertSelective(question);
	}

	@Override
	public int delete(Long id) {
		return questionsMapper.deleteByPrimaryKey(id);
	}

}
