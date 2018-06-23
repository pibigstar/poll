package com.pibigstar.dao;

import com.pibigstar.domain.Questionnaire;

public interface QuestionnaireMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Questionnaire record);

    int insertSelective(Questionnaire record);

    Questionnaire selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Questionnaire record);

    int updateByPrimaryKeyWithBLOBs(Questionnaire record);

    int updateByPrimaryKey(Questionnaire record);
}