package com.aravind.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aravind.model.SignUp;
import com.aravind.repo.SignUpRepo;
@Controller
public class ForgotPWDController {
	@Autowired
	private SignUpRepo repo;
	
	@GetMapping("/forgot-password")
	public String loadForgot() {
		return "forgot";
	}
	
	@PostMapping("/forgot-password")
	public String submitForgot(@RequestParam("email") String email,Model model) {
		SignUp res = repo.findByEmail(email);
		if(res!=null) {
			model.addAttribute("msg", "data found...");
			return "redirect:/reset-password?id="+res.getId();
		}
		else {
			model.addAttribute("msg", "data not found...");
			return "forgot";
		}
	}
	
	
	@GetMapping("/reset-password")
	public String loadReset(@RequestParam("id") Integer id,Model model) {
		model.addAttribute("id", id);
		return "reset-password";
	}
	
	@PostMapping("/reset-password")
	public String submitReset(@RequestParam("id") Integer id,@RequestParam("password") String password,@RequestParam("confirmPassword") String confirmPassword,Model model) {
		if(!password.equals(confirmPassword)) {
			model.addAttribute("msg","password not matched");
			return "redirect:/reset-password?id="+id;
		}
		Optional<SignUp> data = repo.findById(id);
		if(data.isEmpty()) {
			model.addAttribute("msg","password not matched");
			return "redirect:/reset-password?id="+id;
		}
		if (confirmPassword.length() < 6 || confirmPassword.length() > 8) {
		    model.addAttribute("msg", "Password must be between 6 and 8 characters");
		    return "redirect:/reset-password?id=" + id;
		}
		SignUp res = data.get();
		res.setPwd(confirmPassword);
		repo.save(res);
		return "redirect:/signin";
	}
}
