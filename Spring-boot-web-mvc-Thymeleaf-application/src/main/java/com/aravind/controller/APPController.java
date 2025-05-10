package com.aravind.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aravind.model.SignUp;
import com.aravind.repo.SignUpRepo;

import jakarta.servlet.http.HttpSession;

@Controller
public class APPController {
	@Autowired
	private SignUpRepo repo;
	
	@GetMapping("/signup")
	public String loadSignUp(Model model) {
		SignUp up=new SignUp();
		model.addAttribute("signUp", up);
		return "signup";
	}
	
	@PostMapping("/signup")
	public String submitSignUp(@Validated @ModelAttribute("signUp") SignUp signup,BindingResult result,Model model) {
		if(result.hasErrors()) {
			result.getAllErrors().forEach(error -> {
	            System.out.println("Error: " + error.getDefaultMessage());
	        });
	        return "signup";
	    }

	    System.out.println("Signup data: " + signup);
		SignUp res = repo.save(signup);
		if(res!=null) {
			model.addAttribute("msg","data saved success..!");
			  return "redirect:/signin";
		}
		return "signup";
	}
	
	@GetMapping("/signin")
	public String loadSignIn(@ModelAttribute("signUp") SignUp signIn,Model model) {
		model.addAttribute("signUp", new SignUp());
		return "signin";
	}
	
	@PostMapping("/signin")
	public String submitSignIn(@ModelAttribute("signUp") SignUp signIn,Model model,HttpSession session) {
	    SignUp user = repo.findByEmailAndPwd(signIn.getEmail(), signIn.getPwd());
	    System.out.println(user);
	    if (user!=null) {
	        System.out.println("entered..!");
	        session.setAttribute("user", user);
	        return "redirect:/user";
	    } else {
	        model.addAttribute("msg", "Invalid credentials.");
	        System.out.println("not");
	        return "signin";
	    }
	}
	
	@GetMapping("/user")
	public String getUserData(Model model,HttpSession session) {
		SignUp user = (SignUp) session.getAttribute("user");
		if(user!=null) {
			model.addAttribute("user",user);
			return "dashboard";
		}
		return "signin";
	}
	
	@GetMapping("/edit")
	public String editUser(@RequestParam("id") int id,Model model) {
		Optional<SignUp> res = repo.findById(id);
		if(res.isPresent()) {
			model.addAttribute("signUp", res.get());
		}
		return "signup";
	}
	
	@GetMapping("/delete")
	public String deleteUser(Model model,HttpSession session) {
		SignUp user = (SignUp) session.getAttribute("user");
		if(user!=null) {
			repo.delete(user);
			session.invalidate();
			model.addAttribute("msg", "Your account has been deleted successfully.");
			return "redirect:/signup";
		}
		return "redirect:/signup";
	}
	
	
}
