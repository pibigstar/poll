package com.pibigstar.dao;

import com.pibigstar.domain.QQKey;

public interface QQMapper {
    int deleteByPrimaryKey(QQKey key);

    int insert(QQKey record);

    int insertSelective(QQKey record);
}