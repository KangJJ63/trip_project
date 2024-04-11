package com.example.travelproject.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.travelproject.model.dao.UserDao;
import com.example.travelproject.model.dto.UserDto;
import com.example.travelproject.model.entity.UserEntity;
import com.example.travelproject.model.repository.UserRepository;
import com.example.travelproject.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@SuppressWarnings("null")
public class UserServiceImpl implements UserService{
    
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDao userDao;

    public void deleteUser(String userId) {
        UserEntity entity = userDao.findByUserId(userId);
        userDao.deleteUser(entity.getUserId());
    }

    // 로그인 성공시 >> 로그인 유무 저장
    public void updateIsLoginById(String id, Boolean isLogin) {
        UserEntity dto = userRepository.getUserDtoById(id);
        dto.setIsLogin(isLogin);
        userRepository.save(dto);
    }

    public void joinUserDto(UserEntity dto) {
        // 권한 적용
        dto.setRole("USER");
        if (dto.getUserId().equals("admin")) {
            dto.setRole("ADMIN");
        } else if (dto.getUserId().equals("manager")) {
            dto.setRole("MANAGER");
        }

        // 비밀번호 암호화 적용
        String rawPwd = dto.getUserPw();
        String encodedPwd = bCryptPasswordEncoder.encode(rawPwd);
        dto.setUserPw(encodedPwd);

        dto.setIsLogin(false);

        // 신규 유저 database에 저장!!
        userRepository.save(dto);
    }

    public void updateUserDto(UserDto dto) {
        UserEntity entity = userDao.findByUserId(dto.getUserId());
        log.info("[UserServiceImpl][updateUserDto] Start: entity >>> " + entity.toString());

        if (dto.getUserNm() != null) {
            entity.setUserNm(dto.getUserNm());
        }
        if (dto.getUserPw() != null) {
            // 비밀번호 암호화 적용
            String rawPwd = dto.getUserPw();
            String encodedPwd = bCryptPasswordEncoder.encode(rawPwd);
            entity.setUserPw(encodedPwd);
        }
        if(dto.getUserEmail() != null){
            entity.setUserEmail(dto.getUserEmail());
        }
        userRepository.save(entity);
    }

    @Override
    public String findUserIdByEmail(String userNm, String userEmail) {
        UserEntity entity = userRepository.getUserIdByEmail(userNm, userEmail);
        log.info("[UserService][findUserIdByEamil] Start");
        return entity.getUserId();
        
        // if (entity != null) {
        //     return entity.getUserId();
        // } else {
        //     return null; // 이메일에 해당하는 사용자를 찾을 수 없는 경우
        // }
    }

    @Override
    public UserDto findByUserEmail(String email){
        UserEntity entity = userDao.findByUserEmail(email);
        if (entity != null){
            UserDto userDto = new UserDto();
            userDto.setUserEmail(email);
            userDto.setUserId(entity.getUserId());
            userDto.setUserNm(entity.getUserNm());
            return userDto;
        }
        return null;
    }

    public UserDto findByUserId(String userId){
        UserEntity userEntity = userDao.findByUserId(userId);
        if(userEntity !=null){
            UserDto userDto = new UserDto();
            userDto.setUserId(userEntity.getUserId());
            userDto.setUserNm(userEntity.getUserNm());
            userDto.setUserEmail(userEntity.getUserEmail());
            userDto.setRole(userEntity.getRole());
            return userDto;
        }
        return null;
    }
        
        

    @Override
    public List<UserEntity> findAllUser() {
        return userDao.findAllUser();
    }

    // @Override
    // public UserDto findByUserId(String userId) {
    //     UserEntity entity = userDao.findByUserId(userId);
    //     UserDto dto = new UserDto();
    //     dto.setUserId(entity.getUserId());
    //     dto.setUserPw(entity.getUserPw());
    //     dto.setUserEmail(entity.getUserEmail());
    //     dto.setUserNm(entity.getUserNm());
    //     dto.setUserPhNmb(entity.getUserPhNmb());
    //     dto.setRole(entity.getRole());
    //     dto.setUserSex(entity.getUserSex());
    //     dto.setRole(entity.getRole());
        
    //     return null;
    // }

    
}
