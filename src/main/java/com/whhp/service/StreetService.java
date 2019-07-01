package com.whhp.service;

import com.github.pagehelper.PageInfo;
import com.whhp.entity.Street;
import com.whhp.entity.StreetExample;
import java.util.List;

public interface StreetService {
	int deleteStreetByDid(Integer id);

	int insert(Street record);

	int insertSelective(Street record);

	List<Street> selectByExample(StreetExample example);

	Street selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Street record);

	int updateByPrimaryKey(Street record);
	PageInfo<Street> getAllStreet(Integer page, Integer rows);

	int deleteStreet(Integer[] ids);

	//通过区域显示街道
	PageInfo<Street> getAllStreetByDistrict(Integer page, Integer pageSize,Integer district);
	//通过区域显示街道
	List<Street> getAllStreet(Integer district);


}
