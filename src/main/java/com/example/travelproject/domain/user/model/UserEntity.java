package com.example.travelproject.domain.user.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
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
@Entity(name = "UserEntity")
@Table(name = "user")
public class UserEntity {

    @Id // 기본키: 유니크
    @NotBlank
    private String id;
    @NotBlank
    private String pwd;

    @NotBlank
    private String name;
    private String gender;

    private String nickname;

    @Column(unique = true)
    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Pattern(regexp = "^01(?:0|1|[6-9])-?\\d{3,4}-?\\d{4}$", message = "올바른 전화번로를 입력해주세요.")
    private String phone;

    // 일반사용자 / 관리자를 구분용
    private String role;
    // 로그인 유무
    // 확인용

    @Column(columnDefinition = "tinyint(1) default 0")
    private Boolean isLogin;

}
