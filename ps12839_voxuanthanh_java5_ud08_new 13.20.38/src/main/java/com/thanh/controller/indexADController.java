package com.thanh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class indexADController {


	@RequestMapping("/admin/view")
	public String admin() {

		return "admin/dashboard";
	}	

}
