package com.whhp.controller;

import com.github.pagehelper.PageInfo;
import com.whhp.entity.Type;
import com.whhp.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class TypeController {
	@Autowired
	private TypeService typeService;

	@RequestMapping("/getAllType")
	@ResponseBody
	public Map<String,Object> getAllType(Integer page, Integer rows){
		PageInfo<Type> pageInfo = typeService.getAllType(page,rows);
		Map<String,Object> map=new HashMap<>();
		map.put("total",pageInfo.getTotal());
		map.put("rows",pageInfo.getList());
		return map;
	}



	@RequestMapping("/saveType")
	@ResponseBody
	public String saveType(Type type){
		int i = typeService.insertSelective(type);
		System.out.println("i = " + i);
		return  "{\"result\":"+i+"}";
	}


	@RequestMapping("/updateType")
	@ResponseBody
	public String updateType(Type type){
		int i = typeService.updateByPrimaryKeySelective(type);
		System.out.println("i = " + i);
		return  "{\"result\":"+i+"}";
	}


	@RequestMapping("/deleteType")
	@ResponseBody
	public String deleteType(Integer[] ids){
		int i = typeService.deleteType(ids);
		System.out.println("i = " + i);
		return  "{\"result\":"+i+"}";
	}

	@RequestMapping("/delType")
	@ResponseBody
	public String deleteType(Integer id){
		int i = typeService.deleteByPrimaryKey(id);
		System.out.println("i = " + i);
		return  "{\"result\":"+i+"}";
	}
}
