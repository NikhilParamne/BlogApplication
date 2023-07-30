package com.code.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.code.blog.entity.Comment;

public interface CommentRepo extends JpaRepository<Comment, Integer> {

}
