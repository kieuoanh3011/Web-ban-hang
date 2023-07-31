package edu.poly.shop.controller.site;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.poly.shop.domain.CartItem;
import edu.poly.shop.domain.Product;
import edu.poly.shop.service.CartItemServive;
import edu.poly.shop.service.ProductService;

@Controller
@RequestMapping("home/cartitem")
public class CartItemController {
	@Autowired
	CartItemServive cartItemServive;
	
	@Autowired
	ProductService productService;
	
	@RequestMapping("")
	public String cartitem(Model model) {
		model.addAttribute("cartItem", cartItemServive.getAll());
		model.addAttribute("TOTAL", cartItemServive.getAmount());
		return "site/cartitem/cartitem";
	}
	
	@GetMapping("add/{id}")
	public String add(RedirectAttributes param, @PathVariable("id") Long id) {
		Product p = productService.findById(id).orElse(null);
		CartItem item = new CartItem();
		item.setProductId(p.getProductId());
		item.setName(p.getName());
		item.setUnitPrice(p.getUnitPrice());
		cartItemServive.add(item);
		return "forward:/home";
	}
	
	@GetMapping("del/{productId}")
	public String delete(Model model, @PathVariable("productId") Long productId) {
		cartItemServive.remove(productId);
		
		return "redirect:/home/cartitem";
	}
	
	@GetMapping("clear")
	public String clear() {
		cartItemServive.clear();
		
		return "redirect:/home/cartitem";
	}
	
	@PostMapping("update")
	public String update(@RequestParam("id") Long id, @RequestParam("quantity") Integer qty) {
		cartItemServive.update(id, qty);
		return "forward:/home/cartitem";
	}
	
}










