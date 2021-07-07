package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.dao.productDAO;

import com.spring.bean.product;

@Controller
public class HomeController {
	@Autowired
	productDAO proDao;

	@RequestMapping("/product")
	public String product(Model model) {
//		List products = proDao.findAll();
//		model.addAttribute("products", products);
		return "/view/index.jsp";
	}
}
