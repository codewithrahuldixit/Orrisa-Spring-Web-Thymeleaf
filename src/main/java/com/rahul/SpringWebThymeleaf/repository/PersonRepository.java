package com.rahul.SpringWebThymeleaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rahul.SpringWebThymeleaf.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person,Integer> {

}
