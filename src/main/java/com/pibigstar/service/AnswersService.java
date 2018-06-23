package com.pibigstar.service;

import java.util.List;

import com.pibigstar.domain.Answers;
import com.pibigstar.domain.AnswersWithBLOBs;

public interface AnswersService {
	
	public Answers get(Long id);
	
	public List<Answers> findAll();
	
	public int update(AnswersWithBLOBs answers);
	
	public int delete(Long id);
	
	public int add(AnswersWithBLOBs answers);

}
