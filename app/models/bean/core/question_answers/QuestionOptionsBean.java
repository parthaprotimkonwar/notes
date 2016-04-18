package models.bean.core.question_answers;

import java.io.Serializable;

/**
 * Created by pkonwar on 4/18/2016.
 */
public class QuestionOptionsBean implements Serializable{

    private Long questionOptionsId;

    private Long questionId;

    private String option1;

    private String option2;

    private String option3;

    private String option4;

    private String additionalOptions;

    public QuestionOptionsBean(Long questionOptionsId,Long questionId, String option1, String option2, String option3, String option4, String additionalOptions) {
        this.questionOptionsId = questionOptionsId;
        this.questionId = questionId;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.additionalOptions = additionalOptions;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public String getAdditionalOptions() {
        return additionalOptions;
    }

    public void setAdditionalOptions(String additionalOptions) {
        this.additionalOptions = additionalOptions;
    }

    public Long getQuestionOptionsId() {
        return questionOptionsId;
    }

    public void setQuestionOptionsId(Long questionOptionsId) {
        this.questionOptionsId = questionOptionsId;
    }
}
