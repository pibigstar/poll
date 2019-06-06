package com.pibigstar.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.pibigstar.domain.Options;

public interface OptionsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Options record);

    int insertSelective(Options record);

    Options selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Options record);

    int updateByPrimaryKey(Options record);
    
    @Select("select * from poll_options where question_id = #{id}")
    List<Options> findAllByQuestionId(Long id);
}