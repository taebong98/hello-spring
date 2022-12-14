package com.coffee.app.spring.practice.member.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coffee.app.spring.practice.exception.BusinessLogicException;
import com.coffee.app.spring.practice.exception.ExceptionCode;
import com.coffee.app.spring.practice.member.entity.Member;
import com.coffee.app.spring.practice.member.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {
	private final MemberRepository memberRepository;

	@Transactional
	public Member createMember(Member member) {
		verifyExistsEmail(member.getEmail());
		Member createMember = memberRepository.save(member);
		return createMember;
	}

	@Transactional
	public Member updateMember(Member member) {
		Member findMember = findMember(member.getMemberId());

		Optional.ofNullable(member.getName())
			.ifPresent(name -> findMember.setName(name));

		Optional.ofNullable(member.getPhone())
			.ifPresent(phone -> findMember.setPhone(phone));

		Optional.ofNullable(member.getMemberStatus())
			.ifPresent(memberStatus -> findMember.setMemberStatus(memberStatus));

		findMember.setModifiedAt(LocalDateTime.now());
		return memberRepository.save(findMember);
	}

	@Transactional(readOnly = true)
	public Member findMember(long memberId) {
		Optional<Member> optionalMember = memberRepository.findById(memberId);
		Member findMember = optionalMember.orElseThrow(
			() -> new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND));
		return findMember;
	}

	@Transactional(readOnly = true)
	public Page<Member> findMembers(int page, int size) {
		return memberRepository.findAll(PageRequest.of(page, size, Sort.by("memberId").descending()));
	}

	@Transactional
	public void deleteMember(long memberId) {
		Member member = findMember(memberId);
		memberRepository.delete(member);
	}

	private void verifyExistsEmail(String email) {
		Optional<Member> member = memberRepository.findByEmail(email);
		if (member.isPresent())
			throw new BusinessLogicException(ExceptionCode.MEMBER_EXISTS);
	}
}
