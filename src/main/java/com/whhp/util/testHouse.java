package com.whhp.util;

import com.whhp.entity.House;
import com.whhp.service.HouseService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testHouse {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ax = new ClassPathXmlApplicationContext("applicationContext.xml");
		HouseService service = (HouseService) ax.getBean("houseServiceImpl");
		House house = new House();
		house.setPath("sss");
		house.setId("12909");
		int i = service.addHouse(house);
		System.out.println(i);
	}

}
