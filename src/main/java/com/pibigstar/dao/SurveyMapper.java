package com.pibigstar.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.pibigstar.domain.Survey;

public interface SurveyMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Survey record);

    int insertSelective(Survey record);

    Survey selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Survey record);

    int updateByPrimaryKey(Survey record);

    @Select("select * from poll_survey")
	List<Survey> findAll();
}