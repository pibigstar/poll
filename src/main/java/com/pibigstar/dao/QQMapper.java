package com.pibigstar.dao;

import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.pibigstar.domain.QQKey;
import com.pibigstar.domain.extend.QuestionModel;

public interface QQMapper {
    int deleteByPrimaryKey(QQKey key);

    int insert(QQKey record);

    int insertSelective(QQKey record);
    
    @Select("select * from poll_questions where id in (select questions_id from poll_qq where questionnaire_id=#{id})")
    @Results({
    	@Result(property="id",column="id"),
    	@Result(property="options",column="id",many=@Many(select="com.pibigstar.dao.OptionsMapper.findAllByQuestionId"))
    })
    List<QuestionModel> selectAllQuestions(Long id);
    
}