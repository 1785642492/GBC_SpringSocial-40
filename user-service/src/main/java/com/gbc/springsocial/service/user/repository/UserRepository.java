package com.gbc.springsocial.service.user.repository;

import com.gbc.springsocial.shared.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
	Optional<User> findByUsername(String name);
}
