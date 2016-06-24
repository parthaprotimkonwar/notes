package services.service.core.question_answers;

import application.exceptions.BaseException;
import controllers.requestdto.ModuleQuestionAnswerDto;
import models.bean.core.question_answers.ModuleQuestionsAnswersBean;
import models.core.question_answers.ModuleQuestionsAnswers;

import java.util.List;

/**
 * Created by pkonwar on 4/17/2016.
 */
public interface ModuleQuestionAnswerServiceI {

    /**
     * Link Question Answer to Module.
     * @param moduleQuestionsAnswersBean
     * @return
     * @throws BaseException
     */
    ModuleQuestionsAnswers addQuestionAnswersToModule(ModuleQuestionsAnswersBean moduleQuestionsAnswersBean) throws BaseException;

    /**
     * @param moduleQuestionsAnswers
     * @return
     * @throws BaseException
     */
    ModuleQuestionsAnswers addQuestionAnswersToModule(ModuleQuestionsAnswers moduleQuestionsAnswers) throws BaseException;

    /**
     * @param moduleQuestionAnswerDto
     * @return
     * @throws BaseException
     */
    ModuleQuestionsAnswers addQuestionAnswersToModule(ModuleQuestionAnswerDto moduleQuestionAnswerDto) throws BaseException;

    /**
     * Find all Questions Answers from a Module
     * @param moduleId
     * @return
     * @throws BaseException
     */
    List<ModuleQuestionsAnswers> findQuestionAnswersFromAModule(Long moduleId) throws BaseException;

    /**
     * Convert to Module Questions Answer Bean.
     * @param moduleQuestionsAnswersList
     * @return
     * @throws BaseException
     */
    List<ModuleQuestionsAnswersBean> convertToModuleQuestionAnswerBean(List<ModuleQuestionsAnswers> moduleQuestionsAnswersList) throws BaseException;
}
