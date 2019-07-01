package com.whhp.controller;

import com.github.pagehelper.PageInfo;
import com.whhp.entity.Street;
import com.whhp.service.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class StreetController {
	@Autowired
	private StreetService streetService;

	@RequestMapping("/getAllStreet")
	@ResponseBody
	public Map<String,Object> getAllStreet(Integer page,Integer rows){
		PageInfo<Street> pageInfo = streetService.getAllStreet(page,rows);
		Map<String,Object> map=new HashMap<>();
		map.put("total",pageInfo.getTotal());
		map.put("rows",pageInfo.getList());
		return map;
	}


	@RequestMapping("/saveStreet")
	@ResponseBody
	public String saveStreet (Street street){
		int i = streetService.insertSelective(street);
		return "{\"result\":"+i+"}";
	}


	@RequestMapping("/updateStreet")
	@ResponseBody
	public String updateStreet (Street street){
		int i = streetService.updateByPrimaryKeySelective(street);
		return "{\"result\":"+i+"}";
	}


	@RequestMapping("/deleteStreet")
	@ResponseBody
	public String deleteStreet (Integer[] ids){
		int i = streetService.deleteStreet(ids);
		System.out.println("ids = " + ids);
		System.out.println("i = " + i);
		return "{\"result\":"+i+"}";
	}


	@RequestMapping("/getStreetById")
	@ResponseBody
	public Map<String,Object> getStreetById (Integer page,Integer rows,Integer did){
		PageInfo<Street> streetPageInfo = streetService.getAllStreetByDistrict(page, rows, did);
		Map<String,Object> map=new HashMap<>();
		map.put("total",streetPageInfo.getTotal());
		map.put("rows",streetPageInfo.getList());
		return map;
	}
}
