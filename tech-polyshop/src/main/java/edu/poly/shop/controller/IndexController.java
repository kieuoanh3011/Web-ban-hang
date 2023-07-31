package edu.poly.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.poly.shop.service.ProductService;

@Controller
@RequestMapping("home")
public class IndexController {
	@Autowired
	ProductService productService;
	
	@GetMapping("")
	public String getHome(Model model) {
		model.addAttribute("product", productService.findAll());
		return "site/fragments/home";
	}
}
