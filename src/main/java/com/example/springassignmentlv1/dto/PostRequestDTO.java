package com.example.springassignmentlv1.dto;

import lombok.Getter;

@Getter
public class PostRequestDTO {
    private Long id;
    private String password;
    private String title;
    private String author;
    private String contents;
}
