package com.code.blog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.code.blog.entity.Category;
import com.code.blog.entity.Post;
import com.code.blog.entity.User;

public interface PostRepo extends JpaRepository<Post, Integer> {

	List<Post> findByUser(User user);

	List<Post> findByCategory(Category category);
}
