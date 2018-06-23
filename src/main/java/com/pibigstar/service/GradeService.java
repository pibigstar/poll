package com.pibigstar.service;

import java.util.List;

import com.pibigstar.domain.Grade;

public interface GradeService {
	
	public Grade getOneById(Long id);
	
	public List<Grade> list();
	
	public int add(Grade grade);
	
	public int delete(Long id);
	
	public int update(Grade grade);

}
