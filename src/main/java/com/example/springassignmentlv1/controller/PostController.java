package com.example.springassignmentlv1.controller;

import com.example.springassignmentlv1.dto.PostRequestDto;
import com.example.springassignmentlv1.dto.PostResponseDto;
import com.example.springassignmentlv1.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posts")
public class PostController {
    private final PostService postService;

    @PostMapping("")
    public PostResponseDto createPost(@RequestBody PostRequestDto requestDto) {
        return postService.createPost(requestDto);
    }
}
