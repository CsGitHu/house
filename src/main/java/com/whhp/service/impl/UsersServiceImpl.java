package com.whhp.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.whhp.entity.UserCondition;
import com.whhp.entity.Users;
import com.whhp.entity.UsersExample;
import com.whhp.mapper.UsersMapper;
import com.whhp.service.UsersService;
import com.whhp.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {
	@Autowired
	private UsersMapper usersMapper;

	@Override
	public PageInfo<Users> selectPageAll(UserCondition condition) {
		PageHelper.startPage(condition.getPage(), condition.getRows());
		UsersExample usersExample = new UsersExample();
		UsersExample.Criteria criteria = usersExample.createCriteria();
		criteria.andIsadminEqualTo(new Integer(1)); //表示管理员
		//添加查询条件
		if (condition.getName() != null) {
			criteria.andNameLike("%" + condition.getName() + "%");
		}

		if(condition.getTelephone()!=null){
			criteria.andTelephoneLike("%"+condition.getTelephone()+"%");
		}


		if (condition.getStartAge() != null) {
			criteria.andAgeGreaterThan(condition.getStartAge());
		}

		if (condition.getEndAge() != null) {
			criteria.andAgeLessThan(condition.getEndAge());
		}
		List<Users> usersList = usersMapper.selectByExample(usersExample);
		PageInfo<Users> pageInfo=new PageInfo<>(usersList);


		return pageInfo;
	}

	@Override
	public int insert(Users record) {
		return usersMapper.insert(record);
	}

	@Override
	public int insertSelective(Users record) {
		return usersMapper.insertSelective(record);
	}

	@Override
	public int updateByPrimaryKeySelective(Users record) {
		return usersMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Users record) {
		return usersMapper.updateByPrimaryKey(record);
	}

	@Override
	public int deleteUsers(Integer[] ids) {
		return usersMapper.deleteUsers(ids);
	}

	@Override
	public int checkUname(String username) {
		//持久化操作
		UsersExample example=new UsersExample();
		UsersExample.Criteria criteria = example.createCriteria();
		//添加条件
		criteria.andNameEqualTo(username);
		criteria.andIsadminEqualTo(0);
		List<Users> usersList = usersMapper.selectByExample(example);
		return usersList.size()==0?0:1;
	}

	@Override
	public Users login(String username, String password) {
		//SELECT * FROM users WHERE NAME='wjb' AND PASSWORD='202cb962ac59075b964b07152d234b70'
		UsersExample usersExample=new UsersExample();
		UsersExample.Criteria criteria =usersExample.createCriteria();
		//添加条件
		criteria.andIsadminEqualTo(0);  //注册用户
		criteria.andNameEqualTo(username);
		//加密码
		criteria.andPasswordEqualTo(MD5Utils.md5Encrypt(password));

		List<Users> users=usersMapper.selectByExample(usersExample);
		if(users.size()==1){
			return users.get(0);
		}
		return null;
	}

	@Override
	public int addUser(Users users) {
		//设置为前台注册用户
		users.setIsadmin(0);
		//对用户的密码使用MD5加密
		users.setPassword(MD5Utils.md5Encrypt(users.getPassword()));
		return usersMapper.insertSelective(users);
	}
}
