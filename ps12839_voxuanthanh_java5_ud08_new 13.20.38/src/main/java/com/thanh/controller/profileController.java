package com.thanh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class profileController {

	@RequestMapping("/profile/view") 
		public String profile () {
		
		return "index/profileAD";
	}
		
	
}
