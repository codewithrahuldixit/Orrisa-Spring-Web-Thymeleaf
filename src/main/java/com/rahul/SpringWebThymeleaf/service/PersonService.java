package com.rahul.SpringWebThymeleaf.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rahul.SpringWebThymeleaf.model.Person;
import com.rahul.SpringWebThymeleaf.repository.PersonRepository;

@Service
public class PersonService {
	private PersonRepository repository;

	public PersonService(PersonRepository repository) {
		super();
		this.repository = repository;
		repository.save(new Person(101,"Rahul","rahul@gmail.com"));
		repository.save(new Person(102,"balram","balram@gmail.com"));
		repository.save(new Person(103,"Jena","jena@gmail.com"));
	}
	
	public List<Person> retreiveAllPersons(){
		return repository.findAll();
	}

	public Person retreivePersonById(int id) {
	
		return repository.findById(id).get();
	}

}
