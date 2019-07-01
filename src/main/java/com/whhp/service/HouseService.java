package com.whhp.service;

import com.github.pagehelper.PageInfo;
import com.whhp.entity.House;
import com.whhp.entity.HouseCondition;
import com.whhp.entity.HouseExt;

public interface HouseService {
	int addHouse(House house);
	//查询用户的出租房
	PageInfo<HouseExt> getUserHouseByPage(Integer page, Integer rows, Integer uid);
	//查询单条
	HouseExt getHouse(String id);

	//修改
	int updateHouse(HouseExt houseExt);
	//删除
	int delHouse(String id);
	//查询审核的出租房
	PageInfo<HouseExt> getHouseByState(Integer page,Integer rows,Integer ispass);

	//审核出租房
	int passHouse(String id);

	//查询浏览的出租房
	PageInfo<HouseExt> getHouseByBrowser(HouseCondition condition);
}
