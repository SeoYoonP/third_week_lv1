package com.example.springassignmentlv1.controller;

import com.example.springassignmentlv1.dto.PostRequestDTO;
import com.example.springassignmentlv1.dto.PostResponseDTO;
import com.example.springassignmentlv1.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posts")
public class PostController {
    private final PostService postService;

    @PostMapping("")
    public PostResponseDTO createPost(@RequestBody PostRequestDTO requestDto) {
        return postService.createPost(requestDto);
    }
}
