package com.social.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.social.models.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
