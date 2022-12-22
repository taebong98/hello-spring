package com.coffee.app.spring.practice.member.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.coffee.app.spring.practice.order.entity.Order;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Entity
@Setter
@NoArgsConstructor
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long memberId;

	@Column(nullable = false, updatable = false, unique = true)
	private String email;

	@Column(length = 100, nullable = false)
	private String name;

	@Column(length = 13, nullable = false, unique = true)
	private String phone;

	@Column(nullable = false)
	private LocalDateTime createdAt = LocalDateTime.now();

	@Column(nullable = false, name = "LAST_MODIFIED_AT")
	private LocalDateTime modifiedAt = LocalDateTime.now();

	@Enumerated(value = EnumType.STRING)
	private MemberStatus memberStatus = MemberStatus.MEMBER_ACTIVE;

	@OneToMany(mappedBy = "member")
	private List<Order> orders = new ArrayList<>();

	public Member(String email, String name, String phone) {
		this.email = email;
		this.name = name;
		this.phone = phone;
	}

	public enum MemberStatus {
		MEMBER_ACTIVE("활동중"),
		MEMBER_SLEEP("휴면 상태"),
		MEMBER_QUIT("탈퇴 상태");

		@Getter
		private String status;

		MemberStatus(String status) {
			this.status = status;
		}
	}
}
