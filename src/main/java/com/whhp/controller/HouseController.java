package com.whhp.controller;

import com.github.pagehelper.PageInfo;
import com.whhp.entity.HouseExt;
import com.whhp.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller("HouseController2")
@RequestMapping("/admin/")
public class HouseController {
	@Autowired
	private HouseService houseService;

	//查询未审核
	@RequestMapping("getHouseByNoState")
	@ResponseBody
	public Map<String,Object> getHouseByNoState(Integer page,Integer rows){
		//0表示未审核
		PageInfo<HouseExt> pageInfo = houseService.getHouseByState(page, rows, 0);
		Map<String,Object> map=new HashMap<>();
		map.put("total",pageInfo.getTotal());
		map.put("rows",pageInfo.getList());
		return map;
	}



	//查询已审核
	@RequestMapping("getHouseByYesState")
	@ResponseBody
	public Map<String,Object> getHouseByYesState(Integer page,Integer rows){
		//1表示审核
		PageInfo<HouseExt> pageInfo = houseService.getHouseByState(page, rows, 1);
		Map<String,Object> map=new HashMap<>();
		map.put("total",pageInfo.getTotal());
		map.put("rows",pageInfo.getList());
		return map;
	}

	//通过审核
	@RequestMapping("passHouse")
	@ResponseBody
	public Map<String,Object> passHouse(String id){
		int temp = houseService.passHouse(id);//0表示未审核
		Map<String,Object> map=new HashMap<>();
		map.put("result",temp);
		return map;
	}
}
