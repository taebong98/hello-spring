package com.coffee.app.spring.practice.member.controller;

import com.coffee.app.spring.practice.member.dto.MemberPatchDto;
import com.coffee.app.spring.practice.member.dto.MemberPostDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/v1/members")
public class MemberController {
    @PostMapping
    public ResponseEntity postMember(@RequestBody MemberPostDto memberPostDto) {
        // 추후 서비스 계층 연동 필요

        return new ResponseEntity(memberPostDto, HttpStatus.CREATED);
    }

    @PatchMapping("/{member-id}")
    public ResponseEntity patchMember(@RequestParam("member-id") long memberId, MemberPatchDto memberPatchDto) {
        memberPatchDto.setName("홍길동");
        memberPatchDto.setEmail("mockData@aaa.com");
        memberPatchDto.setPhone("010-1111-1111");

        return new ResponseEntity(memberPatchDto, HttpStatus.OK);
    }
}
