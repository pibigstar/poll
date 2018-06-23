package com.pibigstar.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.pibigstar.domain.Answers;
import com.pibigstar.domain.AnswersWithBLOBs;

public interface AnswersMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AnswersWithBLOBs record);

    int insertSelective(AnswersWithBLOBs record);

    AnswersWithBLOBs selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AnswersWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(AnswersWithBLOBs record);

    int updateByPrimaryKey(Answers record);
    
    @Select("select * from poll_answers")
    List<Answers> findAll();
}