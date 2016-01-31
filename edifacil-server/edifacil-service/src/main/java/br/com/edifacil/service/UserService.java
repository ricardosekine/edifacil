package br.com.edifacil.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.edifacil.model.User;
import br.com.edifacil.model.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public User findByName(String userName){

		User user = new User();
		user.setLogged(false);
		
		try {
			user = userRepository.findByName(userName);
			if(null==user){
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return user;
	}
	
}
