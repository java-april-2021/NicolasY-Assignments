package com.nyeon.beltreview.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nyeon.beltreview.model.User;
import com.nyeon.beltreview.services.UserService;
import com.nyeon.beltreview.validators.UserValidator;

@Controller 
@RequestMapping("/")
public class UserController {
	@Autowired
	private UserService uService;
	

	@Autowired
	private UserValidator validator;
	
	
	//registration page
	@GetMapping("/")
	public String baseRoute(@ModelAttribute("register") User register, Model viewModel) {
		return "LoginRegistration.jsp";
	}
	
	//register user
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("user") User user, BindingResult result, Model viewModel, HttpSession session ) {
		validator.validate(user, result);
		if(result.hasErrors()) {
			return "LoginRegistration.jsp";
		}else {
			User newUser = this.uService.registerUser(user);
			session.setAttribute("user__id", newUser.getId());
			return "redirect:/";
		}
	}
	
	//login
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String login(@RequestParam("email") String email, @RequestParam("password") String password, HttpSession session, RedirectAttributes redirectAttr) {
		if(!this.uService.authenticateUser(email, password)) {
			redirectAttr.addFlashAttribute("loginError", "Invalid Credentials");
			return "redirect:/";
		}
		User user = this.uService.findByEmail(email);
		session.setAttribute("user__id", user.getId());
		return "redirect:/";
	}
	
	public Long userId(HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return null;
		}
		return (Long)session.getAttribute("userId");
		
	}
	
	//logout	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("/dogs")
	public String index(Model viewModel, HttpSession session) {
		if(session.getAttribute("user__id") == null) {
		return "redirect:/";
		}
		Long userId = (Long)session.getAttribute("user__id");
		System.out.println(userId);
		User user = this.uService.findUserById(userId);
		viewModel.addAttribute("user", user);
		return "home.jsp";
	}
}
