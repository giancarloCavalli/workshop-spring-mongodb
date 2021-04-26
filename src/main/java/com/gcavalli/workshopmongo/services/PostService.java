package com.gcavalli.workshopmongo.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcavalli.workshopmongo.domain.Post;
import com.gcavalli.workshopmongo.repositories.PostRepository;
import com.gcavalli.workshopmongo.services.exceptions.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repo;
	
	public List<Post> findAll() {
		return repo.findAll();
	}
	
	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado. Id: "+id+"."));
	}
	
	public List<Post> findByTitleContaining(String text) {
		return repo.findByTitleContainingIgnoreCase(text);
	}
	
	public List<Post> findByTextInAnyFieldAndByDateInterval(String text, Date minDate, Date maxDate) {
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
		return repo.findByTextInAnyFieldAndByDateInterval(text, minDate, maxDate);
	}
	
}
