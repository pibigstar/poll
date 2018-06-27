package com.pibigstar.dao;

import java.util.List;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import com.pibigstar.domain.Clazz;
import com.pibigstar.domain.extend.ClazzModel;

public interface ClazzMapper {
	int deleteByPrimaryKey(Long id);

	int insert(Clazz record);

	int insertSelective(Clazz record);

	Clazz selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(Clazz record);

	int updateByPrimaryKeyWithBLOBs(Clazz record);

	int updateByPrimaryKey(Clazz record);

	@Select("select * from poll_clazz")
	@Results({
		//查询关联对象
		@Result(property="id",column="id"),
		@Result(property = "grade",column = "grade_id",one = @One(select="com.pibigstar.dao.GradeMapper.selectByPrimaryKey")),
		@Result(property = "user",column = "user_id",one = @One(select="com.pibigstar.dao.UserMapper.selectByPrimaryKey"))
	})
	List<ClazzModel> findAll();
}