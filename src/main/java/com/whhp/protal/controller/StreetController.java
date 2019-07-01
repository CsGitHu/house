package com.whhp.protal.controller;
import com.whhp.entity.Street;
import com.whhp.service.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;


@Controller("streetController2")
@RequestMapping("/page/")
public class StreetController {
	@Autowired
	private StreetService streetService;

	@RequestMapping("/getStreetByDid")
	@ResponseBody
	public List<Street> getStreetByDid(Integer did){
		System.out.println("getStreetByDid");
		System.out.println("did = " + did);
		//调用业务
		return streetService.getAllStreet(did);
	}


}
