package com.example.springassignmentlv1.repository;

import com.example.springassignmentlv1.dto.PostResponseDto;
import com.example.springassignmentlv1.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByOrderByModifiedAtDesc();
}
