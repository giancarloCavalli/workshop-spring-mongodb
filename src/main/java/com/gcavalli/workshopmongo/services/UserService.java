package com.gcavalli.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcavalli.workshopmongo.domain.User;
import com.gcavalli.workshopmongo.dto.UserDTO;
import com.gcavalli.workshopmongo.repositories.UserRepository;
import com.gcavalli.workshopmongo.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll() {
		return repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado. Id: "+id+"."));
	}
	
	public User insert(User obj) {
		return repo.save(obj);
	}
	
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
}
