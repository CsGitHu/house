package com.whhp.controller;

import com.github.pagehelper.PageInfo;
import com.whhp.entity.District;
import com.whhp.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DistrictController {
	@Autowired
	private DistrictService districtService;

	@RequestMapping("/selectPage")
	@ResponseBody
	public Map<String,Object> selectPage(Integer page,Integer rows){
		PageInfo<District> pageInfo = districtService.selectPage(page, rows);
		Map<String,Object> map=new HashMap<>();
		map.put("total",pageInfo.getTotal());
		map.put("rows",pageInfo.getList());
		return map;
	}


	@RequestMapping("/saveDistrict")
	@ResponseBody
	public String saveDistrict(District district){
		int insert = districtService.insert(district);
		System.out.println("insert = " + insert);
		return  "{\"result\":"+insert+"}";
	}

	@RequestMapping("/updateDistrict")
	@ResponseBody
	public String updateDistrict(District district){
		int i = districtService.updateByPrimaryKey(district);
		System.out.println("修改"+i);
		return "{\"result\":"+i+"}";
	}


	//删除多项
	@RequestMapping("/deleteDistrict")
	@ResponseBody
	public String deleteDistrict(Integer[] ids){
		int i = districtService.deleteDistrict(ids);
		System.out.println("ids = " + ids);
		System.out.println("i = " + i);
		return "{\"result\":"+i+"}";
	}


	//单条
	@RequestMapping("/delDistrict")
	@ResponseBody
	public String delDistrict(Integer id){
		int i = districtService.delDistrict(id);
		System.out.println("i = " + i);
			return "{\"result\":"+i+"}";
	}




//	@RequestMapping("/deleteDistrict")
//	@ResponseBody
//	public String deleteDistrict(@RequestBody String id){
//		System.out.println("id="+id);
//		String s = id.substring(id.indexOf("=") + 1);
//		System.out.println("s = " + s);
//		String[]arr=s.split("%2C");
//		int []ids=new int[arr.length];
//		for (int i = 0; i < arr.length; i++) {
//			ids[i]=Integer.parseInt(arr[i]);
//		}
//		int delete=0;
//		for (int i : ids) {
//			delete+=districtService.deleteByPrimaryKey(i);
//		}
//		System.out.println("delete = " + delete);
//		return "{\"DeleteCounts\":"+delete+"}";
//	}

}
