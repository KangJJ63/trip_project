package com.example.travelproject.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.travelproject.model.entity.BoardEntity;
import com.example.travelproject.model.entity.CommentEntity;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {

    // 사용자 ID에 따른 댓글 검색 메소드 추가
    List<CommentEntity> findByUserUserId(String userId);
    List<CommentEntity> findByBoard(BoardEntity board);
}

