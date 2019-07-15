package com.example.demo;

import java.time.Duration;
import java.util.Random;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/accounts")
public class AccountController {

	@Autowired
	AccountTemplateOperations service;
	
	@Autowired
	AccountMongoRepository mongo;

	@GetMapping
	private Flux<Account> getAllEmployees() {
		return service.findAll();
	}

	@PostMapping
	private Mono<Account> saveAccount(@RequestBody Account account) {
		return mongo.save(account);
	}
	
}
//https://medium.com/@beladiyahardik7/spring-boot-2-mongodb-reactive-programming-b20a9a5bd6c