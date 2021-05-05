package com.nicolas.dojosurvey;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nicolas.dojosurvey.models.Survey;

@Controller
public class DojoSurveyController {
	
	private String[] getLocations() {
		return new String[] {
				"Los Angeles", "San Jose", "Orange County", "Bellevue", "Chicago"
		};
	}
	
	private String[] getFavLanguages() {
		return new String[] {
				"Python", "Mern", "Java", "Ruby"
		};
	}
	
	@RequestMapping("/")
	public String Index(Model model) {
		model.addAttribute("location", getLocations());
		model.addAttribute("languages", getFavLanguages());
		return "index.jsp";
	}
	
	@RequestMapping(value="/survey", method=RequestMethod.POST)
	public String Results(@RequestParam(value="name") String name,
			@RequestParam(value="location") String location,
			@RequestParam(value="language") String language,
			@RequestParam(value="comment") String comment,
			Model model) {
		model.addAttribute("result", new Survey(name, location, language, comment));
		return "results.jsp";
	}
	
}
