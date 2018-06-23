package com.pibigstar.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pibigstar.dao.QuestionnaireMapper;
import com.pibigstar.domain.Questionnaire;
import com.pibigstar.service.QuestionnaireService;

@Service
public class QuestionnaireServiceImpl implements QuestionnaireService {

	@Autowired
	private QuestionnaireMapper questionnarieMapper;
	
	@Override
	public List<Questionnaire> findAll() {
		return questionnarieMapper.findAll();
	}

	@Override
	public Questionnaire get(Long id) {
		return questionnarieMapper.selectByPrimaryKey(id);
	}

	@Override
	public int update(Questionnaire questionnaire) {
		return questionnarieMapper.updateByPrimaryKeySelective(questionnaire);
	}

	@Override
	public int add(Questionnaire questionnaire) {
		return questionnarieMapper.insertSelective(questionnaire);
	}

	@Override
	public int delete(Long id) {
		return questionnarieMapper.deleteByPrimaryKey(id);
	}

}
