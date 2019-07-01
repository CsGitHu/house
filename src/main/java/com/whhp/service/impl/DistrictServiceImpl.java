package com.whhp.service.impl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.whhp.entity.District;
import com.whhp.entity.DistrictExample;
import com.whhp.mapper.DistrictMapper;
import com.whhp.mapper.StreetMapper;
import com.whhp.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class DistrictServiceImpl implements DistrictService {
	@Autowired
	private DistrictMapper districtMapper;
	@Autowired
	private StreetMapper streetMapper;


	@Override
	@Transactional
	public int delDistrict(Integer id) {
		try {
			//删除街道  通过区域删除街道
			streetMapper.deleteStreetByDid(id);
			districtMapper.deleteByPrimaryKey(id);
			//删除区域
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public int insert(District record) {
		return districtMapper.insert(record);
	}

	@Override
	public int insertSelective(District record) {
		return districtMapper.insertSelective(record);
	}

	@Override
	public List<District> selectByExample(DistrictExample example) {
		return null;
	}

	@Override
	public District selectByPrimaryKey(Integer id) {
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(District record) {
		return districtMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(District record) {
		return districtMapper.updateByPrimaryKey(record);
	}

	@Override
	public int deleteDistrict(Integer[] ids) {
		return districtMapper.deleteDistrict(ids);
	}

	@Override
	public PageInfo<District> selectPage(Integer page, Integer rows) {
		PageHelper.startPage(page,rows);
		DistrictExample example=new DistrictExample();
		//DistrictExample.Criteria criteria = example.createCriteria();
		List<District> list = districtMapper.selectByExample(example);
		return new PageInfo<>(list);
	}

	@Override
	public List<District> getAllDistrict() {
		return districtMapper.selectByExample(new DistrictExample());
	}
}
