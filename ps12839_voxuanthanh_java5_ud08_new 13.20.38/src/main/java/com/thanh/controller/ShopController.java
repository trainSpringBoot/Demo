package com.thanh.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.thanh.service.SessionService;
import com.thanh.dao.ProductDAO;
import com.thanh.entity.Product;



@Controller
public class ShopController {

	@Autowired
	ProductDAO dao;
	
	//1. khi chạy gõ localhost:8080/shop/index
			@RequestMapping("/shop/index")
			public String list(Model model, @RequestParam("p") Optional<Integer> p) {
				//2. lấy danh sách sản phẩm
				//1. p là trang thứ mấy cần xuất
				//2. p không xác định ...thì xuất trang thứ 0
				//3. mỗi trang 5 sản phẩm
				Pageable pageable = PageRequest.of(p.orElse(0), 12);
				Page<Product> page = dao.findAll(pageable);
				model.addAttribute("page", page);
				
				return "shop/shop"; //3. view lên trang shop
			}
			@RequestMapping("/product/sort")
			public String sort(Model model, 
					@RequestParam("field") Optional<String> field) {
				Sort sort = Sort.by(Direction.DESC, field.orElse("price"));
				model.addAttribute("field", field.orElse("price").toUpperCase());
				List<Product> items = dao.findAll(sort);
				model.addAttribute("items", items);
				return "product/sort";
			}
			
}
