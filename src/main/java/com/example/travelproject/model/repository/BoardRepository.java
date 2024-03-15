package com.example.travelproject.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.travelproject.model.entity.BoardEntity;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {
    @Query(value = "select * from board where notice_id = :notice_id", nativeQuery = true)
    public BoardEntity selectByNoticeId(@Param(value = "notice_id") long noticeId);

    // @Query(value = "select * from Notice order by desc", nativeQuery = true)
    // public BoardEntity showNotice();
}