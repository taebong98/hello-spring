package com.coffee.app.spring.practice.member.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.coffee.app.spring.practice.dto.MultiResponseDto;
import com.coffee.app.spring.practice.member.dto.MemberPatchDto;
import com.coffee.app.spring.practice.member.dto.MemberPostDto;
import com.coffee.app.spring.practice.member.dto.MemberResponseDto;
import com.coffee.app.spring.practice.member.entity.Member;
import com.coffee.app.spring.practice.member.mapper.MemberMapper;
import com.coffee.app.spring.practice.member.service.MemberService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

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
		MemberResponseDto responseDto = mapper.memberToMemberResponseDto(response);

		return new ResponseEntity(responseDto, HttpStatus.CREATED);
	}

	@PatchMapping("/{member-id}")
	public ResponseEntity patchMember(@PathVariable("member-id") @Positive long memberId,
		@Valid @RequestBody MemberPatchDto memberPatchDto) {
		memberPatchDto.setMemberId(memberId);

		Member member = mapper.memberPatchDtoToMember(memberPatchDto);
		Member updateMember = memberService.updateMember(member);

		return new ResponseEntity(mapper.memberToMemberResponseDto(updateMember), HttpStatus.OK);
	}

	@GetMapping("/{member-id}")
	public ResponseEntity getMember(@PathVariable("member-id") @Positive long memberId) {
		Member response = memberService.findMember(memberId);

		return new ResponseEntity(mapper.memberToMemberResponseDto(response), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity getMembers(@Positive @RequestParam int page,
		@Positive @RequestParam int size) {
		Page<Member> pageMembers = memberService.findMembers(page - 1, size);
		List<Member> members = pageMembers.getContent();

		return new ResponseEntity(new MultiResponseDto(mapper.membersToMembersResponseDto(members), pageMembers),
			HttpStatus.OK);
	}

	@DeleteMapping("/{member-id}")
	public ResponseEntity deleteMember(@PathVariable("member-id") @Positive long memberId) {
		memberService.deleteMember(memberId);

		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
}
