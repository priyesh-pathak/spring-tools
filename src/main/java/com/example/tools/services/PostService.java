package com.example.tools.services;

import com.example.tools.dto.PostDTO;
import com.example.tools.entities.PostEntity;
import com.example.tools.repositories.PostRepo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostService implements PostServiceInterface {

    private final PostRepo postRepo;
    private final ModelMapper modelMapper;

    public PostService(PostRepo postRepo, ModelMapper modelMapper) {
        this.postRepo = postRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<PostDTO> getAllPost() {
        return postRepo.findAll().stream()
                .map(postEntity -> modelMapper.map(postEntity, PostDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public PostDTO createPost(PostDTO postInput) {
        PostEntity postEntity = modelMapper.map(postInput, PostEntity.class);
        PostEntity savedPost = postRepo.save(postEntity);
        return modelMapper.map(savedPost, PostDTO.class);
    }

    public PostDTO getPostById(Long postId) {
//        PostEntity postEntity = postRepo.findById(postId).orElse(null);
//        return modelMapper.map(postEntity, PostDTO.class);
        return postRepo.findById(postId).map(post -> modelMapper.map(post, PostDTO.class)).orElse(null);
    }

    public PostDTO updatePost(Long postId, PostDTO inputPost) {
        PostEntity oldPost = postRepo.findById(postId).orElse(null);
        modelMapper.map(inputPost,oldPost);
        return modelMapper.map(postRepo.save(oldPost),PostDTO.class);

//        return postRepo.findById(postId)
//                .map(post -> {
//                    modelMapper.map(inputPost, post);
//                    return modelMapper.map(postRepo.save(post), PostDTO.class);
//                }).orElse(null);
    }
}
