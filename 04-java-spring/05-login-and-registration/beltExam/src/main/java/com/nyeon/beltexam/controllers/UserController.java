package com.nyeon.beltexam.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nyeon.beltexam.model.Idea;
import com.nyeon.beltexam.model.User;
import com.nyeon.beltexam.services.IdeaService;
import com.nyeon.beltexam.services.UserService;
import com.nyeon.beltexam.validators.UserValidator;

@Controller 
public class UserController {
	@Autowired
	private UserService uService;
	@Autowired
	private IdeaService iService;
	@Autowired
	private UserValidator validator;
	
	
	//registration page
	@GetMapping("/")
	public String baseRoute(@ModelAttribute("user") User user, Model viewModel) {
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
			return "redirect:/dashboard";
		}
	}
	
	//login
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String login(@RequestParam("loginEmail") String email, @RequestParam("loginPassword") String password, HttpSession session, RedirectAttributes redirectAttr) {
		if(!this.uService.authenticateUser(email, password)) {
			redirectAttr.addFlashAttribute("loginError", "Invalid Credentials");
			return "redirect:/";
		}
		User user = this.uService.findByEmail(email);
		session.setAttribute("user__id", user.getId());
		return "redirect:/dashboard";
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
	
	//display dashboard
	@GetMapping("dashboard")
	public String dashboard(@ModelAttribute("idea") Idea idea, Model viewModel, HttpSession session) {
		Long userId = (Long)session.getAttribute("user__id");
		viewModel.addAttribute("user", this.uService.findUserById(userId));
		viewModel.addAttribute("ideas", this.iService.getIdeas());
		return "home.jsp";
	}
	
	//create idea form
	@GetMapping("/newIdea")
	public String createIdeaForm(@ModelAttribute("idea") Idea idea, Model viewModel, HttpSession session) {
		viewModel.addAttribute("user", (Long)session.getAttribute("user__id"));
		return "new.jsp";
	}
	
	//create idea action
	@RequestMapping(value="/createIdea", method=RequestMethod.POST)
	public String createIdea(@Valid @ModelAttribute("idea") Idea idea, BindingResult result, HttpSession session, Model viewModel) {
		if(result.hasErrors()) {
			Long userId=(Long)session.getAttribute("user__id");
			viewModel.addAttribute("user", this.uService.findUserById(userId));
			return "new.jsp";
		}
		System.out.println(idea.getCreator());
		this.iService.create(idea);
		return "redirect:/dashboard";
	}
	
	//display details
	@GetMapping("/show/{id}")
	public String ideaDetails(@ModelAttribute("idea") Idea idea, Model viewModel, HttpSession session) {
		Long userId = this.userId(session);
		Idea showIdea = this.iService.getById(userId);
		return "show.jsp";
	}
	
	@GetMapping("/like/{id}")
	public String like(HttpSession session, @PathVariable("id") Long id) {
		Long userId = (Long)session.getAttribute("user__id");
		User userToLike = this.uService.findUserById(userId);
		Idea likedIdea = this.iService.getById(id);
		this.iService.likeIdea(likedIdea, userToLike);
		return "redirect:/dashboard";
	}	
	
	@GetMapping("/unlike/{id}")
	public String unlike(HttpSession session, @PathVariable("id") Long id) {
		Long userId = (Long)session.getAttribute("user__id");
		User userToLike = this.uService.findUserById(userId);
		Idea likedIdea = this.iService.getById(id);
		this.iService.unlikeIdea(likedIdea, userToLike);
		return "redirect:/dashboard";
	}

	
}