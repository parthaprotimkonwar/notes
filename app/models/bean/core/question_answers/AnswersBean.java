package models.bean.core.question_answers;

import java.io.Serializable;

/**
 * Created by pkonwar on 4/9/2016.
 */

public class AnswersBean implements Serializable{

    public AnswersBean(Long answerId) {
        this.answerId = answerId;
    }

    public AnswersBean(String answer) {
        this.answer = answer;
    }

    private Long answerId;

    private String answer;

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
