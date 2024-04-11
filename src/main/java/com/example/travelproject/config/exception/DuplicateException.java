package com.example.travelproject.config.exception;

import org.springframework.dao.DuplicateKeyException;

import lombok.Getter;

@Getter
public class DuplicateException extends DuplicateKeyException{
    public DuplicateException(String msg) {
        super(msg);
    }
}
