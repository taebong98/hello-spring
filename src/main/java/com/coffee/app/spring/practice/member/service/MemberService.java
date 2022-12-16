package com.coffee.app.spring.practice.member.service;

import com.coffee.app.spring.practice.exception.BusinessLogicException;
import com.coffee.app.spring.practice.exception.ExceptionCode;
import com.coffee.app.spring.practice.member.entity.Member;
import com.coffee.app.spring.practice.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Member createMember(Member member) {
        verifyExistsEmail(member.getEmail());
        Member createMember = memberRepository.save(member);
        return createMember;
    }

    public Member updateMember(Member member) {
        Member findMember = findMember(member.getMemberId());

        Optional.ofNullable(member.getName())
                .ifPresent(name -> findMember.setName(name));

        Optional.ofNullable(member.getPhone())
                .ifPresent(phone -> findMember.setPhone(phone));

        Optional.ofNullable(member.getMemberStatus())
                .ifPresent(memberStatus -> findMember.setMemberStatus(memberStatus));
        return memberRepository.save(findMember);
    }

    public Member findMember(long memberId) {
        Optional<Member> optionalMember = memberRepository.findById(memberId);
        Member findMember = optionalMember.orElseThrow(() -> new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND));
        return findMember;
    }

    public List<Member> findMembers() {
        return (List<Member>) memberRepository.findAll();
    }

    public void deleteMember(long memberId) {
        Member member = findMember(memberId);
        memberRepository.delete(member);
    }


    private void verifyExistsEmail(String email) {
        Optional<Member> member = memberRepository.findByEmail(email);
        if (member.isPresent()) throw new BusinessLogicException(ExceptionCode.MEMBER_EXISTS);
    }
}
