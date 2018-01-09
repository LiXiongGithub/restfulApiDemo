package com.lx.eclipse.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lx.eclipse.dao.EclipseMavenTestMapper;
import com.lx.eclipse.service.EclipseMavenTestService;
import com.lx.eclipse.vo.EclipseMavenTest;

@Service("EclipseMavenTestService")
public class EclipseMavenTestServiceImpl implements EclipseMavenTestService {

	@Autowired EclipseMavenTestMapper eclipseMavenTestMapper ;

	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int insert(EclipseMavenTest record) {
		// TODO Auto-generated method stub
		return eclipseMavenTestMapper.insert(record);
	}

	public int insertSelective(EclipseMavenTest record) {
		// TODO Auto-generated method stub
		return 0;
	}

	public EclipseMavenTest selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public int updateByPrimaryKeySelective(EclipseMavenTest record) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateByPrimaryKey(EclipseMavenTest record) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
