package com.coffee.app.spring.practice.member.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter @NoArgsConstructor @AllArgsConstructor
public class Member {
    private Long memberId;
    private String email;
    private String name;
    private String phone;
}
