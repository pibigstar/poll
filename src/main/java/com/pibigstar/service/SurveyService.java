package com.pibigstar.service;

import java.util.List;

import com.pibigstar.domain.Survey;

public interface SurveyService {
	
	public List<Survey> findAll();
	
	public Survey get(Long id);
	
	public int update(Survey survey);
	
	public int add(Survey survey);
	
	public int delete(Long id);

}
