package com.example.travelproject.model.dao;

import com.example.travelproject.model.entity.UserEntity;

public interface UserDao {

    public void deleteUser(String userId);

    public UserEntity findByUserId(String userId);

    public void insertUser(UserEntity entity);

    public void updateUser(UserEntity entity);

    // [이메일 중복 조회] by 성민
    public UserEntity findByUserEmail(String userEmail);

}
