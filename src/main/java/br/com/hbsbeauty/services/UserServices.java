package br.com.hbsbeauty.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hbsbeauty.model.User;
import br.com.hbsbeauty.repository.UserRepository;

@Service
public class UserServices {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> getAllUsers(){
		return userRepository.getAllUser();
	}

	public User getUsersById(Integer id) {
		return userRepository.getUserById(id);
	}
	
	public User saveOrUpdateUser(User user) {
		return userRepository.save(user);
	}
	
	public String deleteUser(Integer id) {
		try {
			userRepository.deleteById(id);
		}catch(Exception ex){
			return "Erro ao deletar o usuário "+id;
		}
		return "Usuário deletado com sucesso";
		
	}
}
