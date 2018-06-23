package com.pibigstar.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pibigstar.dao.SurveyMapper;
import com.pibigstar.domain.Survey;
import com.pibigstar.service.SurveyService;

@Service
public class SurveyServiceImpl implements SurveyService{

	@Autowired
	private SurveyMapper surveyMapper;
	
	@Override
	public List<Survey> findAll() {
		return surveyMapper.findAll();
	}

	@Override
	public Survey get(Long id) {
		return surveyMapper.selectByPrimaryKey(id);
	}

	@Override
	public int update(Survey survey) {
		return surveyMapper.updateByPrimaryKeySelective(survey);
	}

	@Override
	public int add(Survey survey) {
		return surveyMapper.insertSelective(survey);
	}

	@Override
	public int delete(Long id) {
		return surveyMapper.deleteByPrimaryKey(id);
	}

}
