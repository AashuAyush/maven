package com.visa.prj.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.visa.prj.entity.Product;
import com.visa.prj.service.OrderService;

@Controller // how many different views are being created, as services for actors- customer,
			// administrator
public class ProductController {

	@Autowired
	private OrderService service;
	
	@Autowired
	private ProductValidator validator;

	@RequestMapping("listProducts.do")
	public String getProducts(Model model) { // injecting a model, asked spring to inject a model
		model.addAttribute("products", service.getProducts());
		return "list.jsp"; // returning only view
	}

	@RequestMapping("productForm.do")
	public String getProductForm(Model m) {
		m.addAttribute("product", new Product());
		return "productForm.jsp";
	}

	@RequestMapping("addProduct.do")
	public String addProduct(@ModelAttribute("product") Product p, BindingResult errors) { //internally a map
		validator.validate(p, errors);
		if (errors.hasFieldErrors()) {
			return "productForm.jsp";
		}else {
			service.addProduct(p);
			return "redirect:listProducts.do"; //client side redirect
//			return "listProducts.do"; //server side, repopoulating
		}
		
//		service.addProduct(p);
//		return "redirect:listProducts.do"; //client side redirect
//		return "listProducts.do"; //server side, repopoulating
	}
}
