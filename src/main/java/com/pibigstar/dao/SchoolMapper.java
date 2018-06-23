package com.pibigstar.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.pibigstar.domain.School;

public interface SchoolMapper {
    int deleteByPrimaryKey(Long id);

    int insert(School record);

    int insertSelective(School record);

    School selectByPrimaryKey(Long id);
    
   
    @Select("select * from poll_school")
    List<School> findAll();
    
    @Select("select * from poll_school where name like #{name}")
    List<School> findAllLikeName(String name);
    

    int updateByPrimaryKeySelective(School record);

    int updateByPrimaryKeyWithBLOBs(School record);

    int updateByPrimaryKey(School record);
}