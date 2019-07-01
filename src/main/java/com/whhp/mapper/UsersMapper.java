package com.whhp.mapper;

import com.github.pagehelper.PageInfo;
import com.whhp.entity.UserCondition;
import com.whhp.entity.Users;
import com.whhp.entity.UsersExample;

import java.util.List;

public interface UsersMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(Users record);

	int insertSelective(Users record);

	List<Users> selectByExample(UsersExample example);

	List<Users> selectUsersAll();

	PageInfo<Users> selectPageAll(UserCondition condition);

	Users selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Users record);

	int updateByPrimaryKey(Users record);

	int deleteUsers(Integer[] ids);
	int checkUname(String username);
}