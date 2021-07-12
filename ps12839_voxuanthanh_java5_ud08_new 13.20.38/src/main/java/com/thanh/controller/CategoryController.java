package com.thanh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thanh.dao.CategoryDAO;
import com.thanh.entity.Category;

@Controller
public class CategoryController {
	//1. tiêm vào CategoryDAO
	@Autowired
	CategoryDAO dao; //2. làm việc với bảng Categories
	
	@RequestMapping("/category/index")
	public String index(Model model) {
		//3. tạo 1 đối tượng danh mục 
		Category item = new Category();
		model.addAttribute("item", item);
		//4. lấy ra danh sách các danh mục .... dùng hàm findAll()
		List<Category> items = dao.findAll();
		model.addAttribute("items", items);
		//return "category/index"; // //5. view lên trang index
		return "admin/typography"; // //5. view lên trang index2
	}
	
	
	// khi click vào edit 
	@RequestMapping("/category/edit/{id}")
	public String edit(Model model, @PathVariable("id") String id) {
		//2. tìm theo id
		Category item = dao.findById(id).get();
		model.addAttribute("item", item);
		List<Category> items = dao.findAll();
		model.addAttribute("items", items);
		return "admin/typography";
	}

	
	// khi click vào button create
	@RequestMapping("/category/create")
	public String create(Category item) {
		// thêm 1 danh mục mới vào bảng categories
		dao.save(item);
		return "redirect:/category/index";
	}

	// cập nhật 
	@RequestMapping("/category/update")
	public String update(Category item) {
		dao.save(item);
		return "redirect:/category/edit/" + item.getId();
	}

	@RequestMapping("/category/delete/{id}")
	public String create(@PathVariable("id") String id) {
		dao.deleteById(id);
		return "redirect:/category/index";
	}
	
	
	
	
}
