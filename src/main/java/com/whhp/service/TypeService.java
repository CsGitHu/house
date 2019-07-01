package com.whhp.service;

import com.github.pagehelper.PageInfo;
import com.whhp.entity.Type;

import java.util.List;

public interface TypeService {
	int insert(Type type);

	int insertSelective(Type type);

	int updateByPrimaryKeySelective(Type type);

	int updateByPrimaryKey(Type type);

	PageInfo<Type> getAllType(Integer page, Integer rows);

	int deleteByPrimaryKey(Integer id);

	int deleteType(Integer[] ids);

	List<Type> getAllType();
}
