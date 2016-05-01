package models.bean.core.question_answers;

import application.enums.QA_TYPE;
import models.Constants;
import models.core.question_answers.Answers;
import models.core.question_answers.Questions;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by pkonwar on 4/9/2016.
 */
public class QuestionsAnswerBean implements Serializable{

    public QuestionsAnswerBean(Long questionAnswerId, Long questionId, Long answerId, QA_TYPE type) {
        this.questionAnswerId = questionAnswerId;
        this.questionId = questionId;
        this.answerId = answerId;
        this.type = type;
    }

    private Long questionAnswerId;

    private Long questionId;

    private Long answerId;

    private QA_TYPE type;


    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public Long getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Long answerId) {
        this.answerId = answerId;
    }

    public QA_TYPE getType() {
        return type;
    }

    public void setType(QA_TYPE type) {
        this.type = type;
    }

    public Long getQuestionAnswerId() {
        return questionAnswerId;
    }

    public void setQuestionAnswerId(Long questionAnswerId) {
        this.questionAnswerId = questionAnswerId;
    }
}
