package com.example.springassignmentlv1.controller;

import ch.qos.logback.core.encoder.EchoEncoder;
import com.example.springassignmentlv1.dto.PostRequestDto;
import com.example.springassignmentlv1.dto.PostResponseDto;
import com.example.springassignmentlv1.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posts")
public class PostController {
    private final PostService postService;

    @PostMapping("")
    public PostResponseDto createPost(@RequestBody PostRequestDto postRequestDto) {
        return postService.createPost(postRequestDto);
    }

    @GetMapping("")
    public List<PostResponseDto> getPosts() {
        return postService.getPosts();
    }

    @GetMapping("/{postId}")
    public PostResponseDto getPost(@PathVariable Long postId) {
        return postService.getPost(postId);
    }

    @PutMapping("/{postId}")
    public PostResponseDto updatePost(@PathVariable Long postId, @RequestBody PostRequestDto postRequestDto) {
        return postService.updatePost(postId, postRequestDto);
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<?> deletePost(@PathVariable Long postId, @RequestBody PostRequestDto postRequestDto) {
        try {
            postService.deletePost(postId, postRequestDto);
        } catch (Exception e) {
            return new ResponseEntity<>("비밀번호가 일치하지 않습니다", HttpStatus.UNAUTHORIZED);
        }

        return new ResponseEntity<>("삭제성공!", HttpStatus.OK);
    }
}
