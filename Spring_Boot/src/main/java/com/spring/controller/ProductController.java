package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.bean.category;
import com.spring.bean.product;
import com.spring.dao.categoryDAO;
import com.spring.dao.productDAO;

@Controller
public class ProductController {
	@Autowired
	productDAO proDao;
	@Autowired
	categoryDAO cateDao;

	@RequestMapping("/product")
	public String index(Model model) {
		product item = new product();
		model.addAttribute("item", item);
		List<product> product = proDao.findAll();
		model.addAttribute("pro", product);
		return "/pro";
	}
	
	@RequestMapping("/product/edit/{id}")
	public String edit(Model model, @PathVariable("id") String id) {
		product item = proDao.findById(id).get();
		model.addAttribute("item", item);
		List<product> items = proDao.findAll();
		model.addAttribute("pro", items);
		return "/pro";
	}
	
	@RequestMapping("/product/create")
	public String createProduct(product item) {
		proDao.save(item);
		return "redirect:/product";
	}
	
	@RequestMapping("/product/update")
	public String updateProduct(product item, Model model) {
		proDao.save(item);
		product items = proDao.save(item);
		model.addAttribute("item", items);
		return "redirect:/product/edit/" + item.getIdproduct();
	}

	@RequestMapping("/product/delete/{id}")
	public String createProduct(@PathVariable("id") String id) {
		// 5. xóa danh mục dựa vào id
		proDao.deleteById(id);
		return "redirect:/product";
	}
	//
	
	@RequestMapping("/category")
	public String indexCate(Model model) {
		category item = new category();
		model.addAttribute("item", item);
		List<category> category = cateDao.findAll();
		model.addAttribute("category", category);
		return "/cate";
	}
	
	@RequestMapping("/category/edit/{id}")
	public String editCate(Model model, @PathVariable("id") String id) {
		category item = cateDao.findById(id).get();
		model.addAttribute("item", item);
		List<category> items = cateDao.findAll();
		model.addAttribute("pro", items);
		return "/cate";
	}
	
	@RequestMapping("/category/create")
	public String createCate(category item) {
		cateDao.save(item);
		return "redirect:/category";
	}
	
	@RequestMapping("/category/update")
	public String updateCate(category item, Model model) {
		cateDao.save(item);
		category items = cateDao.save(item);
		model.addAttribute("item", items);
		return "redirect:/category/edit/" + item.getIdcategory();
	}

	@RequestMapping("/category/delete/{id}")
	public String createCate(@PathVariable("id") String id) {
		// 5. xóa danh mục dựa vào id
		cateDao.deleteById(id);
		return "redirect:/category";
	}
}
