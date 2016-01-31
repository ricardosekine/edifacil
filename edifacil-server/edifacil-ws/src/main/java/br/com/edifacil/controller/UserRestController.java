package br.com.edifacil.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.edifacil.model.User;
import br.com.edifacil.service.UserService;

/**
 * The Class UserRestController.
 *
 * @author Ricardo
 */
@RestController
public class UserRestController {
	
	/** The user service. */
	@Autowired
	private UserService userService;
	
	/**
	 * Login.
	 *
	 * @param userName the user name
	 * @param password the password
	 * @return the user
	 */
	@RequestMapping("/login")
	public User login(@RequestParam(value="userName") String userName, @RequestParam(value="password") String password){
		return userService.validateUser(userName, password);
	}
	
}
