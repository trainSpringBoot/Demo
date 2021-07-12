package com.thanh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ServiceController {

	@RequestMapping("/service/view")
	public String service() {
		
		return ("service/service"); //hien thi trang chu index
	}
	
}
