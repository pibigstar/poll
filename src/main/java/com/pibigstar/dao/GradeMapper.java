package com.pibigstar.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import com.pibigstar.domain.Grade;
public interface GradeMapper {
	
    int deleteByPrimaryKey(Long id);

    int insert(Grade record);

    int insertSelective(Grade record);

    Grade selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Grade record);

    int updateByPrimaryKeyWithBLOBs(Grade record);

    int updateByPrimaryKey(Grade record);
    
    @Select("select * from poll_grade")
    List<Grade> findAll();
}