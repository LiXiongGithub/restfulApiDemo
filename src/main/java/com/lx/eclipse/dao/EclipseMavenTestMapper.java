package com.lx.eclipse.dao;

import com.lx.eclipse.vo.EclipseMavenTest;

public interface EclipseMavenTestMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EclipseMavenTest record);

    int insertSelective(EclipseMavenTest record);

    EclipseMavenTest selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EclipseMavenTest record);

    int updateByPrimaryKey(EclipseMavenTest record);
}