package com.pibigstar.dao;

import com.pibigstar.domain.Options;

public interface OptionsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Options record);

    int insertSelective(Options record);

    Options selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Options record);

    int updateByPrimaryKey(Options record);
}