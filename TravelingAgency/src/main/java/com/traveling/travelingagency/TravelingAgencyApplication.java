package com.traveling.travelingagency;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@RestController
public class TravelingAgencyApplication {

	public static void main(String[] args) {
		SpringApplication.run(TravelingAgencyApplication.class, args);
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/hello")
	public String sayHello(@RequestParam(value = "myName", defaultValue = "World") String name){
		return String.format("Hello %s", name);
	}

}
