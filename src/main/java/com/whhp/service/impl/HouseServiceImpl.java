package com.whhp.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.whhp.entity.House;
import com.whhp.entity.HouseCondition;
import com.whhp.entity.HouseExt;
import com.whhp.mapper.HouseMapper;
import com.whhp.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseServiceImpl implements HouseService {
	@Autowired
	private HouseMapper houseMapper;

	@Override
	public int addHouse(House house) {
		return houseMapper.insertSelective(house);
	}

	@Override
	public PageInfo<HouseExt> getUserHouseByPage(Integer page, Integer rows, Integer uid) {
		PageHelper.startPage(page, rows);
		//调用dao层查询出租房
		List<HouseExt> houseList = houseMapper.selectHouseByUserId(uid);
		PageInfo<HouseExt> pageInfo = new PageInfo<>(houseList);
		return pageInfo;
	}

	@Override
	public HouseExt getHouse(String id) {
		return houseMapper.getHouseAndDid(id);
	}

	@Override
	public int updateHouse(HouseExt houseExt) {
		return houseMapper.updateByPrimaryKeySelective(houseExt);
	}

	@Override
	public int delHouse(String id) {
		HouseExt houseExt = new HouseExt();
		//设置主键值
		houseExt.setId(id);
		//设置出租房的状态
		houseExt.setIsdel(new Integer(1));
		return houseMapper.updateByPrimaryKeySelective(houseExt);
	}

	@Override
	public PageInfo<HouseExt> getHouseByState(Integer page, Integer rows, Integer ispass) {
		PageHelper.startPage(page, rows);
		//调用dao层查询出租房
		List<HouseExt> list = houseMapper.getHouseByState(ispass);
		//创建pageInfo
		return new PageInfo<>(list);
	}

	@Override
	public int passHouse(String id) {
		HouseExt houseExt = new HouseExt();
		houseExt.setId(id);
		houseExt.setIspass(1);//通过审核
		return houseMapper.updateByPrimaryKeySelective(houseExt);
	}

	@Override
	public PageInfo<HouseExt> getHouseByBrowser(HouseCondition condition) {
		PageHelper.startPage(condition.getPage(),condition.getPageSize());
		//调用业务  Example只能实现单表条件搜索查询
		if(condition.getTitle()!=null) {
			condition.setTitle("%" + condition.getTitle() + "%");
		}
		List<HouseExt> list=houseMapper.getHouseByBrowser(condition);
		PageInfo<HouseExt> pageInfo=new PageInfo<>(list);
		return pageInfo;
	}
}
