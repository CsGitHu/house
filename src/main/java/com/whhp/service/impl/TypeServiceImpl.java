package com.whhp.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.whhp.entity.Type;
import com.whhp.entity.TypeExample;
import com.whhp.mapper.TypeMapper;
import com.whhp.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {
	@Autowired
	private TypeMapper typeMapper;
	@Override
	public int insert(Type type) {
		return typeMapper.insert(type);
	}

	@Override
	public int insertSelective(Type type) {
		return typeMapper.insertSelective(type);
	}


	@Override
	public int updateByPrimaryKeySelective(Type type) {
		return typeMapper.updateByPrimaryKeySelective(type);
	}

	@Override
	public int updateByPrimaryKey(Type type) {
		return typeMapper.updateByPrimaryKey(type);
	}

	@Override
	public PageInfo<Type> getAllType(Integer page, Integer rows) {
		PageHelper.startPage(page,rows);
		TypeExample typeExample=new TypeExample();
		List<Type> typeList = typeMapper.selectByExample(typeExample);
		PageInfo<Type> pageInfo=new PageInfo<>(typeList);

		return pageInfo;
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return typeMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int deleteType(Integer[] ids) {
		return typeMapper.deleteType(ids);
	}

	@Override
	public List<Type> getAllType() {
		return typeMapper.selectByExample(new TypeExample());
	}
}
