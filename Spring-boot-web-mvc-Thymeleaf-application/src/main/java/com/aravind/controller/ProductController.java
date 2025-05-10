package com.aravind.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aravind.model.Product;
import com.aravind.serviceImpl.ProductService;

@Controller
public class ProductController {
	@Autowired
	private ProductService service;
	
	@GetMapping("/addproduct")
	public String loadProduct(Model model) {
		model.addAttribute("product",new Product());
		return "product";
	}
	
	@PostMapping("/addproduct")
	public String addProduct(@Validated @ModelAttribute("product") Product prod,BindingResult result,Model model) {
		if(result.hasErrors()) {
			return "product";
		}
		Product res = service.save(prod);
		if(res!=null) {
			model.addAttribute("msg", "product added succesfully");
			return "redirect:/getprod";
		}
		return "product";
	}
	
	@GetMapping("/getprod")
	public String getProd(Model model) {
		List<Product> data = service.getAll();
		if(data!=null) {
			model.addAttribute("products",data);
		}
		else {
			model.addAttribute("msg","no records found");
		}
		return "getproducts";
	}
	
	@GetMapping("/editproduct")
	public String editProduct(@RequestParam("id") Integer id,Model model) {
		Product res = service.findById(id);
		if(res!=null) {
			model.addAttribute("product", res);
		}
		return "product";
	}
	
	@GetMapping("/deleteproduct")
	public String deleteProduct(@RequestParam("id") Integer id,Model model) {
		boolean flag = service.deleteById(id);
		if(flag) {
			model.addAttribute("msg", "product deleted success");
			return "redirect:/getprod";
		}
		else {
			model.addAttribute("msg", "product deleted failed");
		}
		return "redirect:/getprod";
	}
}
