package controllers.responsedto;

import application.enums.QA_TYPE;

import javax.swing.text.html.Option;
import java.io.Serializable;

/**
 * Created by pkonwar on 4/19/2016.
 */
public class QuestionAnswersResponseDto implements Serializable {

    public QuestionAnswersResponseDto(String question, String answer, QA_TYPE questionType, Options options) {
        this.question = question;
        this.answer = answer;
        this.questionType = questionType;
        this.options = options;
    }

    public String question;
    public String answer;
    public QA_TYPE questionType;
    public Options options;

}

class Options {
    Options(String option1, String option2, String option3, String option4) {
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
    }

    String option1;
    String option2;
    String option3;
    String option4;
}

