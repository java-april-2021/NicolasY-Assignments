package com.example.demo;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController{
	private int getSessionCount(HttpSession ses) {
		Object sesValue = ses.getAttribute("count");
		if(sesValue == null) {
			setSessionCount(ses, 0);
			sesValue = ses.getAttribute("count");
		}
		return (Integer)sesValue;
	}
	
	private void setSessionCount(HttpSession ses, int val) {
		ses.setAttribute("count", val);
	}
	
	@RequestMapping("/")
	public String Index(HttpSession s) {
		int currentCount = getSessionCount(s);
		setSessionCount(s, ++currentCount);
		return "index.jsp";
	}
	
	@RequestMapping("/counter")
	public String Counter(HttpSession s, Model model) {
		model.addAttribute("count", getSessionCount(s));
		return "count.jsp";
		
	}
	
	@RequestMapping("/add/{times}")
	public String Add(@PathVariable("times") String times, HttpSession s) {
		int j = 1;
		try {
			j = Integer.parseInt(times);
		}
		catch(NumberFormatException e) {
			System.out.println(String.format("Exception Thrown %s", e.getMessage()));
			return "redirect:/";
		}
		int currentCount = getSessionCount(s);
		currentCount += j;
		setSessionCount(s, currentCount);
		return "index.jsp";
	}
}