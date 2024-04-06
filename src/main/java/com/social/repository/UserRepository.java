package com.social.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.social.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	// findBy followed by the name of field to search for matching data
	// field will be retrieved from the model that is provided above
	public Optional<User> findByEmail(String email);

}
