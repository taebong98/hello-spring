package com.coffee.app.spring.practice.member.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MemberPatchDto {
    private String name;
    private String email;
    private String phone;
}
