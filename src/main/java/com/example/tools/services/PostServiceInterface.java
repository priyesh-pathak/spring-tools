package com.example.tools.services;

import com.example.tools.dto.PostDTO;

import java.util.List;

public interface PostServiceInterface {
    List<PostDTO> getAllPost();
    PostDTO createPost(PostDTO postInput);
    public PostDTO getPostById(Long postId);
    public PostDTO updatePost(Long postId, PostDTO postDTO);
}
