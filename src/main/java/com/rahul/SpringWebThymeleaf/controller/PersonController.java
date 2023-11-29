package com.rahul.SpringWebThymeleaf.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rahul.SpringWebThymeleaf.model.Person;
import com.rahul.SpringWebThymeleaf.service.PersonService;

@Controller
public class PersonController {
	
	private PersonService service;
	
	
	public PersonController(PersonService service) {
		super();
		this.service = service;
	}
	@GetMapping({"/","/welcome"})
	public String welcome() {
		return "welcome";
	}
	@GetMapping("/person")
	public String getPerson(@RequestParam int id , Model model) {
		Person person = service.retreivePersonById(id);
		model.addAttribute("persondetail",person);
		return "sample";
	}
	@GetMapping("/addPerson")
	public String addPage() {
		return "addnew";
	}
	@GetMapping("/persons")
	public String getAllPerson(Model model) {
		List<Person> persons = service.retreiveAllPersons();
		model.addAttribute("persons",persons);
		return "index";
	}

}
