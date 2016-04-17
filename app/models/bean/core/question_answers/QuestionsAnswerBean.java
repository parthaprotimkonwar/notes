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

    public QuestionsAnswerBean(Long questionId, Long answerId, QA_TYPE type) {
        this.questionId = questionId;
        this.answerId = answerId;
        this.type = type;
    }

    private Long questionAnswerId;

    private Long questionId;

    private Long answerId;

    private QA_TYPE type;


}
