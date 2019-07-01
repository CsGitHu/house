package com.whhp.service;

import com.github.pagehelper.PageInfo;
import com.whhp.entity.District;
import com.whhp.entity.DistrictExample;

import java.util.List;

public interface DistrictService  {

	int delDistrict(Integer id);

	int insert(District record);

	int insertSelective(District record);

	List<District> selectByExample(DistrictExample example);

	District selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(District record);

	int updateByPrimaryKey(District record);

	int deleteDistrict(Integer[] ids);

	PageInfo<District> selectPage(Integer page, Integer rows);

	List<District> getAllDistrict();
}
