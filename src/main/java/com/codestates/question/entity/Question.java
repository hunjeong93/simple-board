package com.codestates.question.entity;

import com.codestates.answer.entity.Answer;
import com.codestates.member.entity.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionId;
    private LocalDateTime localDateTime; // 리팩토링 대상

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member; // 연관관계 매핑

    private Answer answer; // 1건의 답변만 작성가능하기 때문에 List 필요없다.

//    private Attached attached; // 첨부파일 JPEG/PNG/GIF 업로드 가능 일단 1개만 가능하도록. 2순위

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

//    int hits;  2순위

//    int likes; 2순위

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private QuestionState questionState = QuestionState.QUESTION_UNREGISTRED;


    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private QuestionType questionType = QuestionType.QUESTION_PUBLIC;

    public enum QuestionState {
        QUESTION_UNREGISTRED("답변 미등록"),
        QEUSTION_ANSWERED("답변 완료"),
        QEUSTION_DELETE("질문 삭제");

        @Getter
        private String state;

        QuestionState(String state){
            this.state = state;
        }
    }
    public enum QuestionType {
        QUESTION_PUBLIC("공개글"),
        QUESTION_CECRET("비밀글");

        @Getter
        private String type;

        QuestionType(String type) {
            this.type = type;
        }
    }
}
