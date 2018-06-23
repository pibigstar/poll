package com.pibigstar.dao;

import com.pibigstar.domain.Questions;

public interface QuestionsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Questions record);

    int insertSelective(Questions record);

    Questions selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Questions record);

    int updateByPrimaryKey(Questions record);
}