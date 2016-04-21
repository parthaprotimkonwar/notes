package models.core.question_answers;

import models.Constants;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by pkonwar on 4/9/2016.
 */

@Entity
@Table(name = "ANSWER", schema = Constants.SCHEMA_NAME_CORE_MODULES_QA)
public class Answers implements Serializable{

    public Answers(){}

    public Answers(String answer){
        this.answer = answer;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ANSWER_ID")
    private Long answerId;

    //@Column(name = "ANSWER", nullable = false)
    //@Lob
    @Column(name = "ANSWER", columnDefinition = "text")
    private String answer;

    @OneToMany(mappedBy = "answer", cascade = {CascadeType.MERGE}, orphanRemoval = true)
    private Set<QuestionsAnswer> moduleQuestionAnswers;

    public Long getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Long answerId) {
        this.answerId = answerId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
