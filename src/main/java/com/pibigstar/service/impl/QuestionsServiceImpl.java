package com.pibigstar.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pibigstar.dao.QuestionsMapper;
import com.pibigstar.domain.Questions;
import com.pibigstar.domain.extend.QuestionModel;
import com.pibigstar.service.QuestionsService;

@Service
public class QuestionsServiceImpl implements QuestionsService{

	@Autowired
	private QuestionsMapper questionsMapper;
	
	@Override
	public List<QuestionModel> findAll() {
		return questionsMapper.findAll();
	}

	@Transactional
	@Override
	public Questions get(Long id) {
		return questionsMapper.selectByPrimaryKey(id);
	}

	@Transactional
	@Override
	public int update(Questions question) {
		return questionsMapper.updateByPrimaryKeySelective(question);
	}

	@Transactional
	@Override
	public int add(Questions question) {
		return questionsMapper.insertSelective(question);
	}

	@Transactional
	@Override
	public int delete(Long id) {
		return questionsMapper.deleteByPrimaryKey(id);
	}

}
