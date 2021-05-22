package com.nyeon.controllersandviews.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nyeon.controllersandviews.model.User;
import com.nyeon.controllersandviews.services.UserService;

@Controller
public class Users {
	
	private final UserService userService;
	
	public Users(UserService userService) {
		this.userService = userService;
	}
	
	//display registration page
	@RequestMapping("/registration")
	public String registerForm(@ModelAttribute("user") User user) {
		return "registrationPage.jsp";
	}
	
	//display login page
	@RequestMapping("/")
	public String login() {
		return "loginPage.jsp";
	}
	
	//create new user
	@PostMapping("/registration")
	public String registrationUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		if(result.hasErrors()) {
			return "registration.jsp";
		}
		User u = userService.registerUser(user);
		session.setAttribute("user", u.getId());
		return "redirect:/home";
	}
	
	//authenticate login
	@PostMapping("/login")
	public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model viewModel, HttpSession session) {
		boolean isAuthenticated = userService.authenticateUser(email, password);
		if(isAuthenticated) {
			User u = userService.findByEmail(email);
			session.setAttribute("user", u);
			return "homePage.jsp";
		} else {
			viewModel.addAttribute("error", "Invalid Credentials. Please try again");
			return "loginPage.jsp";
		}
	}
	
	//display home page
	@GetMapping("/home")
	public String home(HttpSession session, Model viewModel) {
		Long userId = (Long) session.getAttribute("user");
		User u = userService.findUserById(userId);
		viewModel.addAttribute("user", u);
		return "homePage.jsp";
		
	}
	
	//logout user
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
