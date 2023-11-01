package com.example.springassignmentlv1.repository;

import com.example.springassignmentlv1.dto.PostResponseDto;
import com.example.springassignmentlv1.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByOrderByModifiedAtDesc();
}
