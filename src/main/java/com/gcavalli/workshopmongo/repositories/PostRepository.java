package com.gcavalli.workshopmongo.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.gcavalli.workshopmongo.domain.Post;

public interface PostRepository extends MongoRepository<Post, String> {
	
	//Exemplo utilizando a anotacao Query
	@Query("{ 'title': { $regex: ?0, $options: 'i'} }")
	List<Post> seachByTitle(String text);
	
	public List<Post> findByTitleContainingIgnoreCase(String text);
	
	@Query(" { $and: [{ 'date': { $gte: ?1 } },"
				+ "{ 'date': { $lte: ?2 } },"
				+ "{ $or: ["
					+ "{ 'title': { $regex: ?0, $options: 'i' } }, { 'body': { $regex: ?0, $options: 'i' } }, { 'comments.text': { $regex: ?0, $options: 'i' } }"
				+ "] }"
			+ "] } ")
	public List<Post> findByTextInAnyFieldAndByDateInterval(String tex, Date minDate, Date maxDate);
}
