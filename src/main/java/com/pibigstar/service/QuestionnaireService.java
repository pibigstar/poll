package com.pibigstar.service;

import java.util.List;

import com.pibigstar.domain.Questionnaire;
import com.pibigstar.domain.extend.QuestionnaireModel;

public interface QuestionnaireService {
	
	public List<Questionnaire> findAll();
	
	public List<QuestionnaireModel> findAllModel();
	
	public Questionnaire get(Long id);
	
	public int update(Questionnaire questionnaire);
	
	public int add(Questionnaire questionnaire);
	
	public int delete(Long id);
	
	

}
