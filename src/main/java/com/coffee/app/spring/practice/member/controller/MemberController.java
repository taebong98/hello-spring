package com.coffee.app.spring.practice.member.controller;

import com.coffee.app.spring.practice.member.dto.MemberPostDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("v1/members")
public class MemberController {
    @PostMapping
    public ResponseEntity postMember(@RequestBody MemberPostDto memberPostDto) {
        // 추후 서비스 계층 연동 필요

        return new ResponseEntity(memberPostDto, HttpStatus.CREATED);
    }
}
