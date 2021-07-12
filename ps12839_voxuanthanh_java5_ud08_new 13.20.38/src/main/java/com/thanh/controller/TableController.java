package com.thanh.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.thanh.dao.AccountDAO;
import com.thanh.dao.ProductDAO;
import com.thanh.entity.Product;
import com.thanh.service.SessionService;
import com.thanh.service.UserService;

@Controller
public class TableController {
	
	@Autowired
	ProductDAO Pddao;
	@Autowired
	AccountDAO dao;
	@Autowired
	UserService userService;
	@Autowired
	SessionService session;
	
	@RequestMapping("/admin/tables")
	public String table(Model model,
			@RequestParam("p") Optional<Integer> p) {
			//3. tạo 1 đối tượng danh mục 
			Product item = new Product();
			model.addAttribute("item", item);
			//4. lấy ra danh sách các danh mục .... dùng hàm findAll()
			Pageable pageable = PageRequest.of(p.orElse(0), 5);
			Page<Product> items = Pddao.findAll(pageable);
			model.addAttribute("items", items);
		return "admin/tables";
	}

////	 hàm 2
	@RequestMapping("/product/edit/{id}")
	public String edit(Model model, @PathVariable("id") Integer id,
			@RequestParam("p") Optional<Integer> p) {
		Product item = Pddao.findById(id).get();
		model.addAttribute("item", item);
		Pageable pageable = PageRequest.of(p.orElse(0), 5);
		Page<Product> items = Pddao.findAll(pageable);
		model.addAttribute("items", items);
		return "admin/tables";
	}

//// hàm 3
	@RequestMapping("/product/create")
	public String create(Product item) {
		Pddao.save(item);
		return "redirect:/admin/tables";
	}

//// hàm 4
	@RequestMapping("/product/update")
	public String update(Product item) {
		Pddao.save(item);
		return "redirect:/product/edit/" + item.getId();
	}

//// hàm 5
	@RequestMapping("/product/delete/{id}")
	public String delete(@PathVariable("id") Integer id) {
		Pddao.deleteById(id);
		return "redirect:/admin/tables";
	}
}
