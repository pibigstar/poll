package com.pibigstar.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.pibigstar.domain.Course;

public interface CourseMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Course record);

    int insertSelective(Course record);

    Course selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKeyWithBLOBs(Course record);

    int updateByPrimaryKey(Course record);
    
    @Select("select * from poll_course")
    List<Course> findAll();
    
    @Select("select * from poll_course where name like #{name}")
    List<Course> findAllLikeName(String name);
    
    
    
}