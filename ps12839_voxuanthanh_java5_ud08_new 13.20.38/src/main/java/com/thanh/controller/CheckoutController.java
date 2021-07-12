package com.thanh.controller;



import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.thanh.dao.AccountDAO;
import com.thanh.entity.Account;
import com.thanh.service.CookieService;
import com.thanh.service.ParamService;
import com.thanh.service.SessionService;
import com.thanh.service.UserService;


@Controller
public class CheckoutController {

	@Autowired
	CookieService cookieService;
	@Autowired
	UserService userService;
	@Autowired
	ParamService paramService;
	@Autowired
	SessionService sessionService;
	@Autowired
	AccountDAO accountDAO;
	
	
	//========================================
	@RequestMapping("/checkout/view")
	public String showlogin(Model model) {
        //show form dang ki, dang nhap
		model.addAttribute("Account",new Account());
		return ("checkout/checkout"); // hien thi trang chu index
	}
	
	@PostMapping("/account/login")
	public String login2(@RequestParam("username") String username, @RequestParam("password") String password,
			Model model) {
		boolean remember = paramService.getBoolean("remember", false);

		Optional<Account> account = accountDAO.findById(username);

		if (username.equals(account.get().getUsername())) {
			if (password.equalsIgnoreCase(account.get().getPassword())) {
				sessionService.set("username", username);
				sessionService.set("fullname", account.get().getFullname());
				sessionService.set("photo", account.get().getPhoto());
				if (remember) {
					cookieService.add("user", username, 10);
					cookieService.add("pass", password, 10);
					System.out.println("luu cookie ok");
				} else {
					cookieService.remove("user");
					cookieService.remove("pass");
				}
			} else {
				model.addAttribute("message", "Sai mật khẩu.");
			}
			if (account.get().isAdmin()) {
				return "redirect:/admin/view";
			} else {
				return "redirect:/home/index";
			}
		} else {
			model.addAttribute("message", "Tài khoản không tồn tại.");
			System.out.println("Tài khoản không tồn tại.");
		}
		return "/checkout/view";
	}
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.setAttribute("Username", null);
		return "redirect:/checkout/view";
	}

}
