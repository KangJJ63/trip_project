package com.example.travelproject.model.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BoardDto {

<<<<<<< HEAD
    private Long noticeId; //
=======
    private int rowNum;
    private Long noticeId; 
>>>>>>> 527df70558bb3e15750bdef66ab5a9f4c64af536
    private String userId; 
    private String title; 
    private String contents;
    private int viewCnt;
    private String createDate;
}
