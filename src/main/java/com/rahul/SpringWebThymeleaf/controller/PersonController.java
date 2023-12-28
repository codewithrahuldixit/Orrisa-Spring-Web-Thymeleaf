package com.rahul.SpringWebThymeleaf.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@GetMapping("/person")
	public String getPerson(@RequestParam int id , Model model) {
		Person person = service.retreivePersonById(id);
		model.addAttribute("persondetail",person);
		return "sample";
	}
	@GetMapping("/addPerson")
	public String addPage(Model model) {
		model.addAttribute("person", new Person());
		return "update";
	}
	//target Code 
	@GetMapping({"/persons","/"})
	public String getAllPerson(Model model) {
		List<Person> persons = service.retreiveAllPersons();
		model.addAttribute("persons",persons);
		//throw new RuntimeException("Exception Arrised In Method");
		return "index";
	}
	@GetMapping("/showFormUpdate/{id}")
	public String showUpdateForm(@PathVariable int id , Model model) {
		Person person = service.retreivePersonById(id);
		model.addAttribute("person", person);
		return "update";
	}
	@PostMapping("/save")
	public String savePerson(@ModelAttribute("person") Person person) {
		//System.out.println(person);
		service.storePerson(person);
		return "redirect:/";
	}
	
	///here
	@GetMapping("/deletePerson/{id}")
	public String savePerson(@PathVariable int id) {
		service.deletePersonByid(id);
		return "redirect:/";
	}
	//here

}
