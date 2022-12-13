package com.coffee.app.spring.practice.member.service;

import com.coffee.app.spring.practice.exception.BusinessLogicException;
import com.coffee.app.spring.practice.exception.ExceptionCode;
import com.coffee.app.spring.practice.member.entity.Member;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberService {
    public Member createMember(Member member) {
        // TODO should business logic

        // TODO member 객체는 나중에 DB에 저장 후 되돌려받는 로직으로 변경해야 한다.
        Member createMember = member;
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
        Member member = new Member(1L, "hgd1@naver.com", "홍길동1", "010-1111-1111");
        throw new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND);

//        return member;
    }

    public List<Member> findMembers() {
        // TODO should business logic

        // TODO member 객체는 나중에 DB에 조회하는 로직으로 변경해야 한다.

        List<Member> members = new ArrayList<>();
        Member member1 = new Member(1L, "hgd1@naver.com", "홍길동1", "010-1111-1111");
        Member member2 = new Member(2L, "hgd2@naver.com", "홍길동2", "010-2222-2222");
        members.add(member1);
        members.add(member2);

        return members;
    }

    public void deleteMember(long memberId) {
        // TODO should business logic

    }
}
