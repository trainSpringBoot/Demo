package com.thanh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class basicController {

	@RequestMapping("/basicAD/view")
	public String basic() {
		
		return "index/basic-tableAD";
	}
}
