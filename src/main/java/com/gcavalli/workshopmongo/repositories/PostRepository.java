package com.gcavalli.workshopmongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.gcavalli.workshopmongo.domain.Post;

public interface PostRepository extends MongoRepository<Post, String> {

}
