package com.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.bean.users;
import com.spring.dao.usersDAO;

@Controller
@RequestMapping("index")
public class LoginController {
	@Autowired
	usersDAO useDao;
	@Autowired
	HttpServletRequest req;

	@GetMapping("login")
	public String show() {
		return "/login";
	}
	
	@PostMapping("login")
	public String get(Model model, @RequestParam("username")String username, @RequestParam("password")String password) {
			users  us = useDao.findById(username).orElse(null);
			if (us == null) {
				req.setAttribute("erorr", "Tài khoản này không tồn tại!");
				// return null;
			}else {
			try {
				if((username.equalsIgnoreCase(us.getUsername())) && password.equalsIgnoreCase(us.getPassword())) {
					System.out.println("login thành công");
					return "redirect:/index/user";
				}else {
					System.out.println("login thất bại");
					model.addAttribute("erorr","Mật khẩu không chính xác");
				}
			} catch (Exception e) {
				System.out.println(e);
				throw new RuntimeException(e);
			}
		}
		return "login";
	}
}
