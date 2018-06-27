package com.pibigstar.service;

import java.util.List;

import com.pibigstar.domain.Clazz;
import com.pibigstar.domain.extend.ClazzModel;

public interface ClazzService {
	
	public Clazz getOneById(Long id);
	
	public List<ClazzModel> list();
	
	public int add(Clazz clazz);
	
	public int delete(Long id);
	
	public int update(Clazz clazz);

}
