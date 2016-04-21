package models.core.question_answers;

import models.Constants;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by pkonwar on 4/9/2016.
 */
@Entity
@Table(name = "QUESTIONS", schema = Constants.SCHEMA_NAME_CORE_MODULES_QA)
public class Questions implements Serializable{

    public Questions() {}

    public Questions(String question) {
        this.question = question;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "QUESTION_ID")
    private Long questionId;

    //@Column(name = "QUESTION", unique = true, nullable = false)
    //@Lob
    @Column(name = "QUESTION", unique = true, nullable = false, columnDefinition = "text")
    private String question;

    @OneToMany(mappedBy ="question", cascade = {CascadeType.MERGE}, orphanRemoval = true)
    private Set<QuestionsAnswer> moduleQuestionAnswers;

    @OneToOne(mappedBy="question", cascade = {CascadeType.MERGE}, orphanRemoval = true)
    private QuestionOptions questionOptions;

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
