package com.example.travelproject.global.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.travelproject.domain.user.model.entity.UserEntity;
import com.example.travelproject.domain.user.model.repository.UserRepository;


@Service
public class AuthUserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        UserEntity userDto = userRepository.getUserDtoById(name);
        // username의 데이터가 database에 존재함(가입함)!!
        if(userDto != null) {
            return new AuthUserDto(userDto);
        }
        

        // 존재하지 않음
        return null;
    }
    
}