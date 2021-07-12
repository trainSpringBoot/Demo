package com.thanh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thanh.dao.AccountDAO;
import com.thanh.entity.Account;

@Controller
public class UserController {
    @Autowired
	AccountDAO dao;
    
 // hien thi danh sach user
    @RequestMapping("/admin/user")
 		public String viewUser (Model model ) {
 			//3. Tao ra mot doi tuong cho user
 			Account item = new Account();
 			model.addAttribute("item",item);
 			//4. lấy ra danh sách các user .... dùng hàm findAll()
 			List<Account> accounts = dao.findAll();
 			model.addAttribute("accounts", accounts);
 			//5. view len trang user
 			return "admin/user";
 		}
 		
 	// hàm 2
 		@RequestMapping("/account/edit/{username}")
 		public String edit(Model model, @PathVariable("username") String username) {
 			Account item = dao.findById(username).get();
 			model.addAttribute("item", item);
 			List<Account> accounts = dao.findAll();
 			model.addAttribute("accounts", accounts);
 			return "admin/user";
 		}

 		// hàm 3
 		@RequestMapping("/account/create")
 		public String create(Account item) {
 			dao.save(item);
 			return "redirect:/admin/user";
 		}

 		// hàm 4
 		@RequestMapping("/account/update")
 		public String update(Account item) {
 			dao.save(item);
 			return "redirect:/account/edit/" + item.getUsername();
 		}

 		// hàm 5
 		@RequestMapping("/account/delete/{username}")
 		public String delete(@PathVariable("username") String username) {
 			dao.deleteById(username);
 			return "redirect:/admin/user";
 		}
 		
}