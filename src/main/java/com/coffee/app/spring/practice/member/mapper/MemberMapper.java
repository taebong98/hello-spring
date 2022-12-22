package com.coffee.app.spring.practice.member.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.coffee.app.spring.practice.member.dto.MemberPatchDto;
import com.coffee.app.spring.practice.member.dto.MemberPostDto;
import com.coffee.app.spring.practice.member.dto.MemberResponseDto;
import com.coffee.app.spring.practice.member.entity.Member;

@Mapper(componentModel = "spring")
public interface MemberMapper {
	Member memberPostDtoToMember(MemberPostDto memberPostDto);

	Member memberPatchDtoToMember(MemberPatchDto memberPatchDto);

	MemberResponseDto memberToMemberResponseDto(Member member);

	List<MemberResponseDto> membersToMembersResponseDto(List<Member> members);
}
