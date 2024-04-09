package com.social.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.social.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	// findBy followed by the name of field to search for matching data
	// field will be retrieved from the model that is provided above
	public Optional<User> findByEmail(String email);

	@Query("SELECT u FROM User u WHERE u.firstName LIKE %:query% OR u.lastName LIKE %:query% OR u.email LIKE %:query%")
	public List<User> searchUser(@Param("query") String query);

}
