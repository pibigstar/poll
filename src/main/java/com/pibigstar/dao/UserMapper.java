package com.pibigstar.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.pibigstar.domain.User;

public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    @Select("select * from poll_user")
    List<User> findAll();
    
}