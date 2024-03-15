package com.example.travelproject.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.travelproject.model.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, String> {
    @Query(value = "select * from user where user_id = :user_id", nativeQuery = true)
    public UserEntity getUserDtoById(@Param(value = "user_id") String name);

    @Query(value = "select * from user where user_nm = :user_nm and user_email = :user_email", nativeQuery = true)
    public UserEntity getUserDtoByEmail(
        @Param(value = "user_nm") String userNm,
        @Param(value = "user_email") String userEmail);

    // [이메일 중복 조회] by 성민
    public UserEntity findByUserEmail(String userEmail);
}