package com.pibigstar.service;

import java.util.List;

import com.pibigstar.domain.Clazz;

public interface ClazzService {
	
	public Clazz getOneById(Long id);
	
	public List<Clazz> list();
	
	public int add(Clazz clazz);
	
	public int delete(Long id);
	
	public int update(Clazz clazz);

}
