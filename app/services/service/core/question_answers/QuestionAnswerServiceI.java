package services.service.core.question_answers;

import models.core.question_answers.QuestionsAnswer;

/**
 * Created by pkonwar on 4/17/2016.
 */
public interface QuestionAnswerServiceI {

    QuestionsAnswer addQuestionAnswer(Long questionId, Long answerId);
}
