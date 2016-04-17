package services.service.core.question_answers;

import models.core.question_answers.ModuleQuestionsAnswer;
import models.core.question_answers.Questions;

/**
 * Created by pkonwar on 4/17/2016.
 */
public interface ModuleQuestionServiceI {


    ModuleQuestionsAnswer addQuestionAnswerToModule(Long questionId, Long answerId, Long moduleId);
}
