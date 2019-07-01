package com.whhp.util;

import com.whhp.entity.Users;
import com.whhp.service.UsersService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class testUsers {
	@Autowired
	UsersService service;
	@Test
	public void UsersTest(){
		int i = service.addUser(new Users("王二狗","123","12234",0,24));
		System.out.println("i = " + i);
	}

}
