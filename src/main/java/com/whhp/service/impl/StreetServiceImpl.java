package com.whhp.service.impl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.whhp.entity.Street;
import com.whhp.entity.StreetExample;
import com.whhp.mapper.StreetMapper;
import com.whhp.service.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class StreetServiceImpl implements StreetService {
	@Autowired
	private StreetMapper streetMapper;


	@Override
	public int deleteStreetByDid(Integer id) {
		return streetMapper.deleteStreetByDid(id);
	}


	@Override
	public int insert(Street record) {
		return streetMapper.insert(record);
	}

	@Override
	public int insertSelective(Street record) {
		return streetMapper.insertSelective(record);
	}

	@Override
	public List<Street> selectByExample(StreetExample example) {
		return null;
	}

	@Override
	public Street selectByPrimaryKey(Integer id) {
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(Street record) {
		return streetMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Street record) {
		return streetMapper.updateByPrimaryKey(record);
	}

	@Override
	public PageInfo<Street> getAllStreet(Integer page, Integer rows) {
		PageHelper.startPage(page,rows);
		StreetExample streetExample=new StreetExample();
		List<Street> list = streetMapper.selectByExample(streetExample);
		return new PageInfo<>(list);
	}

	@Override
	public int deleteStreet(Integer[] ids) {
		return streetMapper.deleteStreet(ids);
	}

	@Override
	public PageInfo<Street> getAllStreetByDistrict(Integer page, Integer pageSize, Integer district) {
		PageHelper.startPage(page,pageSize);
		//查询街道
		StreetExample streetExample=new StreetExample();
		StreetExample.Criteria criteria = streetExample.createCriteria();
		//传条件
		criteria.andDistrictIdEqualTo(district);
		List<Street> list = streetMapper.selectByExample(streetExample);
		PageInfo<Street> pageInfo=new PageInfo<>(list);
		return pageInfo;
	}


	@Override
	public List<Street> getAllStreet(Integer district) {
		StreetExample streetExample=new StreetExample();
		StreetExample.Criteria criteria = streetExample.createCriteria();
		//传条件
		criteria.andDistrictIdEqualTo(district);
		List<Street> list = streetMapper.selectByExample(streetExample);
		return list;
	}
}
