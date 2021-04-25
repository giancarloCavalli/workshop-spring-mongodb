package com.gcavalli.workshopmongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.gcavalli.workshopmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
