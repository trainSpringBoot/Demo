package com.thanh.controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thanh.bean.MailInfo;
import com.thanh.service.MailerService;

@Controller
public class ContactController {
	@Autowired
	MailerService mailer;
	
	@RequestMapping("/contact/view")
	public String contact(Model model) {
					MailInfo mailinfo = new MailInfo();
					model.addAttribute("mailinfo", mailinfo);
					
		return "contact-us/contact-us";
	}
	
		
		@PostMapping("/mailer/send")
		public String send(Model model, MailInfo mailinfo) throws MessagingException {
			// 1. mail người nhận
			mailer.send(mailinfo.getTo(), mailinfo.getSubject(), mailinfo.getBody());
			model.addAttribute("mail", mailinfo);
			return "contact-us/send";
		}
		
}
