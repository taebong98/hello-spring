package com.coffee.app.spring.practice.member.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public class MemberResponseDto {
    private String name;
    private String phone;
    private String email;
}
