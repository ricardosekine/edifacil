package br.com.edifacil.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.edifacil.model.User;
import br.com.edifacil.service.UserService;

@RestController
public class UserRestController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/user")
	public User teste(){
		User user = userService.findByName("ricardo");
		return user;
	}
	
	@RequestMapping("/login")
	public User login(){
		
		
		return null;
	}
	
}
