package com.codestates.answer.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long answerId;

    private LocalDateTime localDateTime; //등록날짜?

    private String content;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private AnswerType answerType; // 질문의 타입을 따라감. 변경시 같이 변경

    public enum AnswerType {
        ANSWER_PUBLIC("공개 답글"),
        ANSWER_CECRET("비밀 답글");

        @Getter
        private String type;

        AnswerType(String type) {
            this.type =type;
        }
    }
}
