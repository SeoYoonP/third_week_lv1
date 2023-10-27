package com.example.springassignmentlv1.entity;

import com.example.springassignmentlv1.dto.PostRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "posts")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Post extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String title;
    @Column
    private String password;
    @Column
    private String author;
    @Column
    private String contents;

    public Post(PostRequestDTO requestDTO) {
        this.title = requestDTO.getTitle();
        this.author = requestDTO.getAuthor();
        this.contents = requestDTO.getContents();
        this.password = requestDTO.getPassword();
    }
}
