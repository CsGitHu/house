package com.whhp.controller;

import com.github.pagehelper.PageInfo;
import com.whhp.entity.UserCondition;
import com.whhp.entity.Users;
import com.whhp.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class UsersController {
	@Autowired
	private UsersService usersService;

	@RequestMapping("/selectPageAll")
	@ResponseBody
	public Map<String, Object> selectPageAll(UserCondition condition) {
		PageInfo<Users> pageInfo = usersService.selectPageAll(condition);
		Map<String, Object> map = new HashMap<>();
		map.put("total", pageInfo.getTotal());
		map.put("rows", pageInfo.getList());
		System.out.println("map集合 = " + map);
		return map;

	}

	@RequestMapping("/saveUsers")
	@ResponseBody
	public String saveUsers(Users users) {
		int insert = usersService.insertSelective(users);
		System.out.println("insert = " + insert);
		return "{\"result\":" + insert + "}";
	}

	@RequestMapping("/updateUsers")
	@ResponseBody
	public String updateUsers(Users users) {
		int insert = usersService.updateByPrimaryKeySelective(users);
		System.out.println("insert = " + insert);
		return "{\"result\":" + insert + "}";
	}

	@RequestMapping("/deleteUsers")
	@ResponseBody
	public String deleteUsers(Integer[] ids) {
		int insert = usersService.deleteUsers(ids);
		System.out.println("insert = " + insert);
		return "{\"result\":" + insert + "}";
	}

}
