package com.coffee.app.spring.practice.member.mapper;

import com.coffee.app.spring.practice.member.dto.MemberPatchDto;
import com.coffee.app.spring.practice.member.dto.MemberPostDto;
import com.coffee.app.spring.practice.member.dto.MemberResponseDto;
import com.coffee.app.spring.practice.member.entity.Member;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MemberMapper {
    Member memberPostDtoToMember(MemberPostDto memberPostDto);
    Member memberPatchDtoToMember(MemberPatchDto memberPatchDto);
    MemberResponseDto memberToResponseDto(Member member);
}
