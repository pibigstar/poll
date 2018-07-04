package com.pibigstar.dao;

import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import com.pibigstar.domain.Questionnaire;
import com.pibigstar.domain.extend.QuestionnaireModel;

public interface QuestionnaireMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Questionnaire record);

    int insertSelective(Questionnaire record);

    Questionnaire selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Questionnaire record);

    int updateByPrimaryKeyWithBLOBs(Questionnaire record);

    int updateByPrimaryKey(Questionnaire record);

    @Select("select * from poll_questionnaire")
	List<Questionnaire> findAll();
    
    
    @Select("select * from poll_questionnaire")
    @Results({
    	@Result(property="id",column="id"),
    	@Result(property="questions",column="id",many=@Many(select="com.pibigstar.dao.QQMapper.selectAllQuestions")),
    })
    List<QuestionnaireModel> findAllModel();
    
}