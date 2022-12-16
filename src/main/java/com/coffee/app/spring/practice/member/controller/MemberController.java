package com.coffee.app.spring.practice.member.controller;

import com.coffee.app.spring.practice.member.dto.MemberPatchDto;
import com.coffee.app.spring.practice.member.dto.MemberPostDto;
import com.coffee.app.spring.practice.member.dto.MemberResponseDto;
import com.coffee.app.spring.practice.member.entity.Member;
import com.coffee.app.spring.practice.member.mapper.MemberMapper;
import com.coffee.app.spring.practice.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/members")
public class MemberController {
    private final MemberService memberService;
    private final MemberMapper mapper;


    @PostMapping
    public ResponseEntity postMember(@Valid @RequestBody MemberPostDto memberPostDto) {
        Member member = mapper.memberPostDtoToMember(memberPostDto);
        Member response = memberService.createMember(member);
        MemberResponseDto responseDto = mapper.memberToResponseDto(response);

        return new ResponseEntity(responseDto, HttpStatus.CREATED);
    }

    @PatchMapping("/{member-id}")
    public ResponseEntity patchMember(@PathVariable("member-id") @Positive long memberId,
                                      @Valid @RequestBody MemberPatchDto memberPatchDto) {
        memberPatchDto.setMemberId(memberId);

        Member member = mapper.memberPatchDtoToMember(memberPatchDto);
        Member updateMember = memberService.updateMember(member);

        return new ResponseEntity(mapper.memberToResponseDto(updateMember), HttpStatus.OK);
    }

    @GetMapping("/{member-id}")
    public ResponseEntity getMember(@PathVariable("member-id") @Positive long memberId) {
        Member response = memberService.findMember(memberId);

        return new ResponseEntity(mapper.memberToResponseDto(response), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getMembers() {
        List<Member> members = memberService.findMembers();
        List<MemberResponseDto> memberResponseDtos = members.stream()
                .map(member -> mapper.memberToResponseDto(member))
                .collect(Collectors.toList());
        return new ResponseEntity(memberResponseDtos, HttpStatus.OK);
    }

    @DeleteMapping("/{member-id}")
    public ResponseEntity deleteMember(@PathVariable("member-id") @Positive long memberId) {
        memberService.deleteMember(memberId);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
