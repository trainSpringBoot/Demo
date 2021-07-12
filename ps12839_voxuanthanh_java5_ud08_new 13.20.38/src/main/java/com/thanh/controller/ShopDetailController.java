package com.thanh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShopDetailController {

	@RequestMapping("/shop-detail/view")
	public String shopdetail() {
		
		return "shop-detail/shop-detail";
	}
}
