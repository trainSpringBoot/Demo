package com.thanh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WishlistController {

	@RequestMapping("/wishlist/view")
	public String wishlist() {
		
		return ("wishlist/wishlist"); //hien thi trang chu index
	}
	
}
