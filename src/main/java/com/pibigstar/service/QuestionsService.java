package com.pibigstar.service;

import java.util.List;

import com.pibigstar.domain.Questions;
import com.pibigstar.domain.extend.QuestionModel;

public interface QuestionsService {
	
	public List<QuestionModel> findAll();
	
	public Questions get(Long id);
	
	public int update(Questions question);
	
	public int add(Questions question);
	
	public int delete(Long id);

}
