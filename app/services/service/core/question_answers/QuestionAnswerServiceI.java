package services.service.core.question_answers;

import application.exceptions.BaseException;
import models.bean.core.question_answers.QuestionsAnswerBean;
import models.core.question_answers.QuestionsAnswer;

/**
 * Created by pkonwar on 4/17/2016.
 */
public interface QuestionAnswerServiceI {

    QuestionsAnswer addQuestionAnswer(QuestionsAnswerBean questionsAnswerBean) throws BaseException;
}
