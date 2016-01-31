package br.com.edifacil.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.edifacil.model.User;

@RestController
public class UserRestController {

	private static final String name = "ricardo.sekine";
	private static final String password = "ri9013";
	
	@RequestMapping("/user")
	public User teste(){
		User user = new User();
		user.setId(1l);
		user.setName("Ricardo Sekine");
		user.setPassword("ri9013");
		return user;
	}
	
	@RequestMapping("/login")
	public boolean login(){
		boolean res = false;
		
		return res;
	}
	
}
