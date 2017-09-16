package com.mandar.coffeeshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mandar.coffeeshop.domain.Product;
import com.mandar.coffeeshop.service.ProductService;

@Controller
public class ProductsController {

	@Autowired
	private ProductService productService;
	
	@RequestMapping("/product/{id}")
	public String product(@PathVariable Long id, Model model){
		model.addAttribute("product", productService.findOne(id));
		return "product";
	}
	
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public String productsList(Model model){
		model.addAttribute("products", productService.findAll());
		return "products";
	}
	
	@RequestMapping(value = "/saveproduct", method = RequestMethod.POST)
	@ResponseBody
	public String saveProduct(@RequestBody Product product){
		productService.save(product);
        return product.getIdp().toString();
	}
	
}
