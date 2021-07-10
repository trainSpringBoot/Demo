package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.dao.usersDAO;
import com.spring.bean.users;

@Controller
@RequestMapping("index")
public class UserController {
	@Autowired
	usersDAO useDao;
	@GetMapping("user")
	public String showUser(Model model) {
		users item = new users();
		model.addAttribute("item", item);
		List<users> us = useDao.findAll();
 		model.addAttribute("list_user", us);
		return "/showUser";
	}
	
	@GetMapping("edit/{username}")
	public String edit(Model model, @PathVariable("username") String username) {
		users item = useDao.findById(username).get();
		model.addAttribute("item", item);
		List<users> items = useDao.findAll();
		model.addAttribute("items", items);
		return "/showUser";
	}
	@RequestMapping("/create")
	public String create(users us) {
		useDao.save(us);
		return "redirect:/index/user";
	}
	@RequestMapping("/update")
	public String update(users up) {
		useDao.save(up);
		return "redirect:/index/user";
	}
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id") String id) {
		useDao.deleteById(id);
		return "redirect:/index/user";
	}
}
