package com.thanh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thanh.dao.ProductDAO;
import com.thanh.entity.Product;

@Controller
public class HomeController {
@Autowired
ProductDAO dao;

	@RequestMapping("/home/index")
	public String index(Model model) {
		List<Product> items = dao.findAll(); // truy váº¥n táº¥t cáº£
//		model.addAttribute("items", items);
		return "index/index"; //hien thi trang chu index
	}
	
}
