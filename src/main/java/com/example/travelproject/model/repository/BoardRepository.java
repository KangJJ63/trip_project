package com.example.travelproject.model.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.travelproject.model.entity.BoardEntity;

import jakarta.transaction.Transactional;


public interface BoardRepository extends JpaRepository<BoardEntity, Long>{
    //해당 게시글 가져오기 
    public BoardEntity findByNoticeId(long noticeId);
    //keyword로 게시글 검색
    public List<BoardEntity> findByTitleContaining(String keyword);
    //게시글 조회수 +1
    // @Query(value = "update board b set b.view_cnt = b.view_cnt+1 where b.notice_id = :noticeId")
    // BoardEntity updateViewCnt(@Param(value = "noticeId") Long noticeId);
    @Modifying
    @Transactional
    @Query(value="update board b set b.view_cnt = b.view_cnt + 1 where b.notice_id = :noticeId",nativeQuery=true)
    public void updateViewCnt(@Param("noticeId") Long noticeId);
}
