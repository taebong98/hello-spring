package com.coffee.app.spring.practice.member.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter @Setter
@Entity
public class Member {
    @Id @GeneratedValue
    private Long memberId;
    private String email;
    private String name;
    private String phone;
}
