package com.whhp.protal.controller;
import com.whhp.entity.Users;
import com.whhp.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/page/")
public class UserController {
	@Autowired
	private UsersService usersService;

	@RequestMapping("checkUname")
	@ResponseBody
	public String checkUname(String username) {
		//调用业务
		int i = usersService.checkUname(username);
		System.out.println("i = " + i);
	     return "{\"result\":"+i+"}";

	}

	@RequestMapping("regUser")
	public String regUser(Users users){
		//调用业务
		System.out.println("users = " + users);
		int temp=usersService.addUser(users);
		if(temp>0)
			return "login";
		else
			return "error";
	}


	@RequestMapping("login")
	public String regUser(String username, String password, Model model, HttpSession session){
		//调用业务
		Users user=usersService.login(username,password);
		if(user==null) {
			model.addAttribute("info","用户名密码错误!");
			return "login";  //继续登入
		}
		else {
			//只要登入:使用session或者cookie保存登入的信息
			session.setAttribute("user",user);
			session.setMaxInactiveInterval(600); //30秒
			return "redirect:getUserHouse";  //用户中心的管理页
		}
	}

}
