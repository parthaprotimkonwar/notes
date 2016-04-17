package models.core.question_answers;

import application.enums.QA_TYPE;
import models.Constants;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by pkonwar on 4/9/2016.
 */
@Entity
@Table(name = "QUESTIONS_ANSWERS", schema = Constants.SCHEMA_NAME_CORE_MODULES_QA)
public class QuestionsAnswer implements Serializable{

    public QuestionsAnswer(Questions question, Answers answer, QA_TYPE type) {
        this.question = question;
        this.answer = answer;
        this.type = type;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "QUESTION_ANSWER_ID")
    private Long questionAnswerId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "QUESTION_ID")
    private Questions question;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ANSWER_ID")
    private Answers answer;

    @Column(name = "TYPE")
    @Enumerated(value = EnumType.ORDINAL)
    private QA_TYPE type;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "moduleIdQuestionsAnswersId.questionsAnswer")
    private Set<ModuleQuestionsAnswers> moduleQuestionAnswers;

}
