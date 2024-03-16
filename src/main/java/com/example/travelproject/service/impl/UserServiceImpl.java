package com.example.travelproject.service.impl;

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

    public void updateUserDto(UserEntity dto) {
        // UserEntity entity = userRepository.getUserDtoById(dto.getUserId());
        UserEntity entity = userRepository.findOneUser(dto.getUserId());
        log.info("[UserServiceImpl][updatePw] Start: entity >>> " + entity);

        if (dto.getUserNm() != null) {
            entity.setUserNm(dto.getUserNm());
        }
        if (dto.getUserPw() != null) {
            // 비밀번호 암호화 적용
            String rawPwd = dto.getUserPw();
            String encodedPwd = bCryptPasswordEncoder.encode(rawPwd);
            entity.setUserPw(encodedPwd);
        }
        log.info("[UserService]: " + entity);
        userRepository.save(entity);
    }

    public void updatePw(UserDto dto) {
        UserEntity entity = userRepository.getUserDtoById(dto.getUserId());
        log.info("[UserServiceImpl][updatePw] Start: entity >>> " + entity);
        if (dto.getUserNm() != null) {
            entity.setUserNm(dto.getUserNm());
        }
    }

    @Override
    public String findUserIdByEmail(String userNm, String userEmail) {
        UserEntity entity = userRepository.getUserIdByEmail(userNm, userEmail);
        log.info("[UserService][findUserIdByEamil] Start");
        if (entity != null) {
            return entity.getUserId();
        } else {
            return null; // 이메일에 해당하는 사용자를 찾을 수 없는 경우
        }
    }

    public UserDto findByUserId(String userId){
        UserEntity userEntity = userDao.findByUserId(userId);
        UserDto userDto = new UserDto();
        userDto.setUserId(userEntity.getUserId());
        userDto.setUserNm(userEntity.getUserNm());
        userDto.setRole(userEntity.getRole());
        return userDto;
    }
}
