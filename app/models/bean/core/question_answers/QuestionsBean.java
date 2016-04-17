package models.bean.core.question_answers;

import java.io.Serializable;

/**
 * Created by pkonwar on 4/9/2016.
 */
public class QuestionsBean implements Serializable{

    public QuestionsBean(Long questionId) {
        this.questionId = questionId;
    }

    public QuestionsBean(String question) {
        this.question = question;
    }

    private Long questionId;

    private String question;

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
