package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/accounts")
public class AccountController {
	
	@Autowired
	AccountTemplateOperations service;
	
	@GetMapping
	private Flux<Account> getAllEmployees() {
	    return service.findAll();
	}

}
//https://medium.com/@beladiyahardik7/spring-boot-2-mongodb-reactive-programming-b20a9a5bd6c