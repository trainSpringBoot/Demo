package com.thanh.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.thanh.service.SessionService;
import com.thanh.bean.Item;
import com.thanh.entity.Account;
import com.thanh.entity.Order;
import com.thanh.entity.OrderDetail;
import com.thanh.dao.AccountDAO;
import com.thanh.dao.OrderDAO;
import com.thanh.dao.ProductDAO;
import com.thanh.service.ShoppingCartService;

@Controller
public class ShoppingCartController {
	@Autowired
	ShoppingCartService cart; // 1. tiêm Spring Bean đã viết ở bài trước
	@Autowired
	AccountDAO accountDao;
	@Autowired
	OrderDAO orderDao;
	@Autowired
	ProductDAO productDao;
	@Autowired
	SessionService session;
	
	//2. xem giỏ hàng
	@RequestMapping("/cart/view")
	public String view(Model model) {
		model.addAttribute("cart", cart);
		model.addAttribute("sumcart",cart.getCount());
		return "cart/cart"; //3. view lên trang giỏ hảng index
	}
	
	///////////////////////////////////
	
	@RequestMapping("/cart/add/{id}")
	public String add(@PathVariable("id") Integer id) {
		cart.add(id);
		return "redirect:/cart/view"; // hiển thị giỏ hàng
	}
	@RequestMapping("/cart/remove/{id}")
	public String remove(@PathVariable("id") Integer id) {
		cart.remove(id);
		return "redirect:/cart/view";
	}
	@RequestMapping("/cart/update/{id}")
	public String update(@PathVariable("id") Integer id, 
	@RequestParam("qty") Integer qty) {
		cart.update(id, qty);
		return "redirect:/cart/view";
	}
	@RequestMapping("/cart/clear")
	public String clear() {
		cart.clear();
		return "redirect:/cart/view";
	}
	
	@RequestMapping("/cart/checkout")
	public String checkout() {
		
		String username = session.get("username");
		Account currentAcc = null;
//		System.out.println("username: " + username);
		if (accountDao.findById(username).isPresent()) {
			currentAcc = accountDao.findById(username).get();
			Order ord = new Order();
			ord.setAccount(currentAcc);
			ord.setCreateDate(new Date());
			ord.setAddress("123");
			List<OrderDetail> details = new ArrayList<>();
			for (Item item : cart.getItems()) {
				OrderDetail od = new OrderDetail();
				od.setOrder(ord);
				productDao.findById(item.getId()).ifPresent(p->{
					od.setProduct(p);
				});
				od.setPrice(item.getPrice());
				od.setQuantity(item.getQty());
				details.add(od);
			}
			ord.setOrderDetails(details);
			orderDao.save(ord);
			cart.clear();
		}
		
		return "redirect:/cart/view";
	}
	
}
