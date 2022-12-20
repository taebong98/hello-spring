package com.coffee.app.spring.practice.member.dto;


import com.coffee.app.spring.practice.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
public class MemberResponseDto {
    private Long memberId;
    private String name;
    private String phone;
    private String email;
    private Member.MemberStatus memberStatus;

//    public String getMemberStatus() {
//        return memberStatus.getStatus();
//    }
}
