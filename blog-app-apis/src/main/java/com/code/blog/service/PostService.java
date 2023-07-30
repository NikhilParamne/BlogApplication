package com.code.blog.service;

import java.util.List;

import com.code.blog.entity.Post;
import com.code.blog.payloads.PostDto;
import com.code.blog.payloads.PostResponse;

public interface PostService {

	// create

	PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);

	// update

	PostDto updatePost(PostDto postDto, Integer postId);

	// delete

	void deletePost(Integer postId);

	// get all posts

	PostResponse getAllPosts(Integer pageNumber, Integer pageSize, String sortBy, String sortDir);

	// get single post

	PostDto getPostById(Integer postId);

	// get all posts by category

	List<PostDto> getPostsByCategory(Integer categoryId);

	// get all posts by user

	List<PostDto> getPostsByUser(Integer userId);

	// search posts

	List<Post> searchPosts(String keyword);

}
