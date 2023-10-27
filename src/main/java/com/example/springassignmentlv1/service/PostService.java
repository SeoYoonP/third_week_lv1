package com.example.springassignmentlv1.service;

import com.example.springassignmentlv1.dto.PostRequestDTO;
import com.example.springassignmentlv1.dto.PostResponseDTO;
import com.example.springassignmentlv1.entity.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.springassignmentlv1.repository.PostRepository;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public PostResponseDTO createPost(PostRequestDTO requestDTO) {
        Post post = new Post(requestDTO);
        post = postRepository.save(post);
        return new PostResponseDTO(post);
    }
}
