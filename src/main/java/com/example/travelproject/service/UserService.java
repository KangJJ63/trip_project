package com.example.travelproject.service;

import com.example.travelproject.model.dto.UserDto;
import com.example.travelproject.model.entity.UserEntity;

public interface UserService {

    public void deleteUser(String userId);

    // 로그인 성공시 >> 로그인 유무 저장
    public void updateIsLoginById(String id, Boolean isLogin);

    public void joinUserDto(UserEntity dto);

    public void updateUserDto(UserEntity dto);
<<<<<<< HEAD

    public String findUserId(UserEntity dto);
<<<<<<< HEAD
    
=======
>>>>>>> 5dc288253579a96b3c79ddab6da27c8bac9e9287
=======
    public UserDto findByUserId(String userId);
>>>>>>> 527df70558bb3e15750bdef66ab5a9f4c64af536
}
