package com.codestates.member.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;
    @Column(nullable = false, updatable = false, unique = true)
    private String email;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private MemberGrade memberGrade = MemberGrade.MEMBER_NORMAL;

    public enum MemberGrade {
        MEMBER_ADMIN("관리자"),
        MEMBER_NORMAL("일반 회원");

        @Getter
        private String grade;

        MemberGrade(String grade) {
            this.grade = grade;
        }
    }
}
