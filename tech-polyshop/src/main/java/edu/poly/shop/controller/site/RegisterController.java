package edu.poly.shop.controller.site;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.poly.shop.domain.Account;
import edu.poly.shop.domain.Customer;
import edu.poly.shop.service.AccountService;
import edu.poly.shop.service.CustomerService;

@Controller
@RequestMapping("home/register")
public class RegisterController {
	@Autowired
	AccountService accountService;
	
	@Autowired
	CustomerService customerService;
	
	@GetMapping("")
	public String viewRegister(Model model) {
		model.addAttribute("account", new Account());
		return "site/accounts/register";
	}
	
	@PostMapping("")
	public String register(@Valid @ModelAttribute("account") Account ac, BindingResult result, @ModelAttribute("email")String email) {
		if (result.hasErrors()) {
			return "forward:home/register";
		}
		Customer c = new Customer();
		c.setEmail(email);
		customerService.save(c);
		accountService.save(ac);
		
		return "redirect:/home/login";
	}
}
