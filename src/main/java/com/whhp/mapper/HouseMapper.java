package com.whhp.mapper;

import com.whhp.entity.House;
import com.whhp.entity.HouseCondition;
import com.whhp.entity.HouseExample;
import com.whhp.entity.HouseExt;

import java.util.List;

public interface HouseMapper {
    int deleteByPrimaryKey(String id);

    int insert(House record);

    int insertSelective(House record);

    List<House> selectByExample(HouseExample example);

    House selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(House record);

    int updateByPrimaryKey(House record);

    //查询用户发布的出租房   底层是连接查询,修改实体类
    List<HouseExt> selectHouseByUserId(Integer uid);
    //查询出租房信息（带区域id）
    HouseExt getHouseAndDid(String id);

    //查询未审核的出租房
    List<HouseExt> getHouseByState(Integer state);

    //查询浏览的出租房信息
    List<HouseExt> getHouseByBrowser(HouseCondition condition);
}