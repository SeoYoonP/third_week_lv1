package com.example.springassignmentlv1.service;

import com.example.springassignmentlv1.dto.PostRequestDto;
import com.example.springassignmentlv1.dto.PostResponseDto;
import com.example.springassignmentlv1.entity.Post;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.springassignmentlv1.repository.PostRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;



    public PostResponseDto createPost(PostRequestDto postRequestDto) {
        Post post = new Post(postRequestDto);
        post = postRepository.save(post);
        return new PostResponseDto(post);
    }

    public List<PostResponseDto> getPosts() {
        return postRepository.findAllByOrderByModifiedAtDesc()
                .stream()
                .map(PostResponseDto::new)
                .collect(Collectors.toList());
    }

    public PostResponseDto getPost(Long postId) {
        Post post = findPost(postId);
        return new PostResponseDto(post);
    }


    @Transactional
    public PostResponseDto updatePost(Long postId, PostRequestDto postRequestDto) {
        Post post = findPost(postId);
        if (!post.getPassword().equals(postRequestDto.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다");
        }
        post.update(postRequestDto);
        return new PostResponseDto(post);
    }

    private Post findPost(Long postId) {
        return postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 글입니다."));
    }

    public void deletePost(Long postId, PostRequestDto postRequestDto) {
        Post post = findPost(postId);
        if (!post.getPassword().equals(postRequestDto.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다");
        }
        postRepository.delete(post);
    }
}
