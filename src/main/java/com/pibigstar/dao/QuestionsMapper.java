package com.pibigstar.dao;

import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.pibigstar.domain.Questions;
import com.pibigstar.domain.extend.QuestionModel;

public interface QuestionsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Questions record);

    int insertSelective(Questions record);

    Questions selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Questions record);

    int updateByPrimaryKey(Questions record);

    @Select("select * from poll_questions")
    @Results({
    	 /** 一对多 */
    	@Result(property="id",column="id"),
    	@Result(property="options",column="id",many=@Many(select="com.pibigstar.dao.OptionsMapper.findAllByQuestionId"))
    })
	List<QuestionModel> findAll();
}