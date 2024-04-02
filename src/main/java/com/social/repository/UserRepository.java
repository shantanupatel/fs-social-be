package com.social.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.social.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
