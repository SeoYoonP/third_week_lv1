package com.example.springassignmentlv1.dto;

import lombok.Getter;

@Getter
public class PostRequestDto {
    private Long postId;
    private String password;
    private String title;
    private String author;
    private String contents;
}
