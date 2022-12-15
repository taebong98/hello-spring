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
        // TODO should business logic
        // TODO DB에 있는 Member 인지 검증로직 구현
        verifyExistsEmail(member.getEmail());

        Member createMember = memberRepository.save(member);
        return createMember;
    }

    public Member updateMember(Member member) {
        // TODO should business logic

        // TODO member 객체는 나중에 DB에서 조회후 되돌려받는 로직으로 변경해야 한다.

        Member updatedMember = member;
        return updatedMember;
    }

    public Member findMember(long memberId) {
        // TODO should business logic

        // TODO member 객체는 나중에 DB에 조회하는 로직으로 변경해야 한다.

        return null;
    }

    public List<Member> findMembers() {
        // TODO should business logic

        // TODO member 객체는 나중에 DB에 조회하는 로직으로 변경해야 한다.

        return null;
    }

    public void deleteMember(long memberId) {
        // TODO should business logic
        throw new NullPointerException();

    }


    private void verifyExistsEmail(String email) {
        Optional<Member> member = memberRepository.findByEmail(email);
        if (member.isPresent()) throw new BusinessLogicException(ExceptionCode.MEMBER_EXISTS);
    }
}
