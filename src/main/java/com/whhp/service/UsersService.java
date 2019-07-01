package com.whhp.service;

import com.github.pagehelper.PageInfo;
import com.whhp.entity.UserCondition;
import com.whhp.entity.Users;


public interface UsersService  {

	PageInfo<Users> selectPageAll(UserCondition condition);

	int insert(Users record);

	int insertSelective(Users record);

	int updateByPrimaryKeySelective(Users record);

	int updateByPrimaryKey(Users record);

	int deleteUsers(Integer[] ids);

	int checkUname(String username);

	//登入
	Users login(String username, String password);

	//添加 注册
	int addUser(Users users);
}
