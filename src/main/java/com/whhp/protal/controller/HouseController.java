package com.whhp.protal.controller;

import com.github.pagehelper.PageInfo;
import com.whhp.entity.*;
import com.whhp.service.DistrictService;
import com.whhp.service.HouseService;

import com.whhp.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.List;

@Controller
@RequestMapping("/page/")
public class HouseController {
	@Autowired
	private TypeService typeService;
	@Autowired
	private DistrictService districtService;
	@Autowired
	private HouseService houseService;

	@RequestMapping("goFaBu")
	public String goFaBu(Model model) {
		//查询所有类型
		List<Type> types = typeService.getAllType();
		//查询所有域名域
		List<District> districts = districtService.getAllDistrict();

		//使用model将数据传递到页面
		model.addAttribute("types", types);
		model.addAttribute("districts", districts);
		//跳转页面
		return "fabu";
	}

	@RequestMapping("addHouse")
	public String addHouse(House house, @RequestParam(value = "pfile", required = false) CommonsMultipartFile pfile, HttpSession session) throws Exception {
		//将文件保存在服务器中  D:\\images
		String fname = pfile.getOriginalFilename();
		String expName = fname.substring(fname.lastIndexOf("."));
		//保存文件名
		String saveName = System.currentTimeMillis() + expName;
		File file = new File("D:\\images\\" + saveName);
		//保存
		pfile.transferTo(file);

		//保存数据库的记录  house已经接收部分表单数据
		//设置编号
		house.setId(System.currentTimeMillis() + "");
		//设置用户编号
		Users user = (Users) session.getAttribute("user");
		house.setUserId(user.getId());
		//设置审核状态 0  如果表中有默认值 可不设
		house.setIspass(0);
		//设置是否删除  0
		house.setIsdel(0);
		//设置图片路径
		house.setPath(saveName);
		//保存数据
		if (houseService.addHouse(house) > 0) {
			//调用业务
			//添加信息到数据库
			//houseService.addHouse(house);
			//重定向
			return "redirect:goFaBu";
		} else {
			//成功上传的图片删除
			file.delete();
			//重定向
			return "redirect:goFaBu";
		}
	}

	//查询出租房   用户id在session中
	//page 表示页面传的页码
	@RequestMapping("getUserHouse")
	public String getUserHouse(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page, HttpSession session, Model model) {
		//判断page是否为空
		page = page == null ? 1 : page;
		System.out.println(233);
		Users user = (Users) session.getAttribute("user");
		PageInfo<HouseExt> pageInfo = houseService.getUserHouseByPage(page, 2, user.getId());
		//把数据设置到域中
		model.addAttribute("pageInfo", pageInfo);
		//跳转页面
		return "guanli";
	}

	//修改显示某个出租房信息
	@RequestMapping("getHouse/{id}")
	public String getHouse(@PathVariable String id, Model model) {
		//查询所有类型
		List<Type> types = typeService.getAllType();
		//查询所有域名域
		List<District> districts = districtService.getAllDistrict();
		//获取出租方信息  调用查询单个出租房的业务(dao)
		HouseExt house = houseService.getHouse(id);
		//将数据设置到域中
		model.addAttribute("types", types);
		model.addAttribute("districts", districts);
		model.addAttribute("house", house);

		return "upfabu";
	}

	//修改
	@RequestMapping("updateHouse")
	public String updateHouse(String oldPic, HouseExt houseExt, @RequestParam(value = "pfile", required = false) CommonsMultipartFile pfile) throws Exception {
		//修改时判断用户有么有修改图片
		File file = null;
		if (pfile.getOriginalFilename().equals("")) {
			//System.out.println("不修改图片");
			//不需要实现文件上传,同时house实体的path属性无需设置属性
		} else {
			//System.out.println("修改图片");
			//上传新的图片,删除旧的图片,设置path为上传新的图片名称
			file = new File("D:/images/" + oldPic);
			pfile.transferTo(file);  //保存
			//设置图片名称
			houseExt.setPath(oldPic);
		}

		//保存数据库的记录  house已经接收部分表单数据
		//设置编号 从表单获取
		//设置审核状态 0 如果表中有默认值 可以不用设
		//house.setIspass(0);
		//设置是否有删除  0
		//house.setIsdel(0);
		//设置图片路径
		// house.setPath(saveName);
		if (houseService.updateHouse(houseExt) <= 0) {
			//成功上传的图片
			if (file != null) file.delete();
		}
		//重定向到查询用户出租房
		return "redirect:getUserHouse";
	}

	@RequestMapping("delHouse")
	@ResponseBody
	public String delHouse(String id) {
		//调用业务
		int temp = houseService.delHouse(id);
		return "{\"result\":" + temp + "}";
		//return "redirect:getUserHouse";  //跳转到查询用户出租房
	}


	//查询所有浏览出租房的信息
	@RequestMapping("goList")
	public String goList(HouseCondition condition,Model model) {
		//page = page == null ? 1 : page;
		//调用业务获取出租房
		PageInfo<HouseExt> pageInfo = houseService.getHouseByBrowser(condition);
		//将分页信息设置到作用域中
		model.addAttribute("pageInfo",pageInfo);

		if (condition.getTitle()!=null) {
			condition.setTitle(condition.getTitle().replaceAll("%", ""));
		}
			//回显查询条
		model.addAttribute("condition",condition);
		return "list";
	}
}
