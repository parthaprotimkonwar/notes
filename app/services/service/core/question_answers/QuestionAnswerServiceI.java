package services.service.core.question_answers;

import application.exceptions.BaseException;
import controllers.responsedto.QuestionAnswersResponseDto;
import models.bean.core.question_answers.QuestionsAnswerBean;
import models.core.question_answers.ModuleQuestionsAnswers;
import models.core.question_answers.QuestionsAnswer;

import java.util.List;

/**
 * Created by pkonwar on 4/17/2016.
 */
public interface QuestionAnswerServiceI {

    /**
     * Add question Answer
     * @param questionsAnswerBean
     * @return
     * @throws BaseException
     */
    QuestionsAnswer addQuestionAnswer(QuestionsAnswerBean questionsAnswerBean) throws BaseException;

    /**
     * Generate Question Answers in the required format for output.
     * @param moduleQuestionsAnswers
     * @return
     */
    List<QuestionAnswersResponseDto> generateQuestionAnswers(List<ModuleQuestionsAnswers> moduleQuestionsAnswers) throws BaseException;
}
