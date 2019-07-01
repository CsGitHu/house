package com.whhp.protal.controller;

import com.whhp.entity.District;
import com.whhp.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller("districtController2")
@RequestMapping("/page/")
public class DistrictController {
	@Autowired
	private DistrictService districtService;

	//发送请求 获取类型的异步数据
	@RequestMapping("getDistrict")
	@ResponseBody
	public List<District> getDistrict(){
		return districtService.getAllDistrict();
	}
}
