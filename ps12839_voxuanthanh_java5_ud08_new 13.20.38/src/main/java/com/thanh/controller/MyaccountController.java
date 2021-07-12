package com.thanh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyaccountController {

	@RequestMapping("/myaccount/view")
	public String myaccount() {
		
		return ("my-account/my-account"); //hien thi trang chu index
	}
	
}
