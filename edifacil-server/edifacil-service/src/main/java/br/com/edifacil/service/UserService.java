package br.com.edifacil.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.edifacil.exception.EdifacilException;
import br.com.edifacil.model.User;
import br.com.edifacil.model.repository.UserRepository;

/**
 * The Class UserService.
 */
@Service
public class UserService {

	/** The user repository. */
	@Autowired
	private UserRepository userRepository;
	
	/**
	 * Validate user.
	 *
	 * @param userName the user name
	 * @param password the password
	 * @return the user
	 */
	public User validateUser(String userName, String password){

		User user = new User();
		user.setLogged(false);
		
		try {
			user = userRepository.findByName(userName);
			
			if(null==user){
				throw new EdifacilException("Usuario não cadastrado");
				
			}else if(null!=user && !user.getPassword().equals(password)){
				throw new EdifacilException("Senha incorreta");
				
			}else{
				user.setLogged(true);
				user.setId(null);
				user.setPassword(null);
				user.setMessage("Usuário é registrado");
			}
			
		} catch (EdifacilException ex){
			user = new User();
			user.setMessage(ex.getMessage());
			
		} catch (Exception e) {
			user.setMessage("Erro ao executar login, por favor tente mais tarde.");
		}
		return user;
	}
	
}
