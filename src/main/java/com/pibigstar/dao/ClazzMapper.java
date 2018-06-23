package com.pibigstar.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.pibigstar.domain.Clazz;

public interface ClazzMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Clazz record);

    int insertSelective(Clazz record);

    Clazz selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Clazz record);

    int updateByPrimaryKeyWithBLOBs(Clazz record);

    int updateByPrimaryKey(Clazz record);
    
    @Select("select * from poll_clazz")
    List<Clazz> findAll();
}