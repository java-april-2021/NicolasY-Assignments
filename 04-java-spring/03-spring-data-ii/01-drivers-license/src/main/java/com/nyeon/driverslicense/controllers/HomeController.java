package com.nyeon.driverslicense.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nyeon.driverslicense.model.License;
import com.nyeon.driverslicense.model.Person;
import com.nyeon.driverslicense.services.DriversLicenseService;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	private DriversLicenseService dService;
	
	//main page
	@GetMapping("")
	public String index(@ModelAttribute("person") Person person, Model viewModel) {
		List<Person> people = dService.allPeople();
		viewModel.addAttribute("people", people);
		return "/main.jsp";
	}
	
	//add person form
	@GetMapping("person/new")
	public String addPerson (@ModelAttribute("person") Person person) {
		return "/index.jsp";
	}
	
	//add license form
	@GetMapping("license/new")
	public String addLicense (@ModelAttribute("license") License license) {
		return "license.jsp";
	}
	
	//add person
	@PostMapping("/person/new")
	public String newPerson (@ModelAttribute("person") License license, BindingResult result) {
		dService.saveLicense(license);
		return "redirect:/";
	}
	
	//add license
	@PostMapping("license/new")
	public String newLicense (@ModelAttribute("license") Person person, BindingResult result) {
		dService.savePerson(person);
		return "redirect:/";
	}
	
	//details page
	@GetMapping("/person/{id}")
	public String details (@PathVariable("id") Long id, Model viewModel) {
		Person person = dService.getPerson(id);
		viewModel.addAttribute("person", person);
		return "/details.jsp";
	}
	
}
