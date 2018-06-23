package com.pibigstar.dao;

import com.pibigstar.domain.Survey;

public interface SurveyMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Survey record);

    int insertSelective(Survey record);

    Survey selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Survey record);

    int updateByPrimaryKey(Survey record);
}