package services.service.impl.core.question_answers;

import application.exceptions.BaseException;
import application.exceptions.ErrorConstants;
import models.bean.core.question_answers.ModuleQuestionsAnswersBean;
import models.core.Modules;
import models.core.question_answers.ModuleIdQuestionsAnswersId;
import models.core.question_answers.ModuleQuestionsAnswers;
import models.core.question_answers.QuestionsAnswer;
import repository.core.ModulesRepository;
import repository.core.question_answers.ModuleQuestionAnswersRepository;
import repository.core.question_answers.QuestionsAnswerRepository;
import services.service.core.question_answers.ModuleQuestionAnswerServiceI;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

/**
 * Created by pkonwar on 4/17/2016.
 */
@Named
@Singleton
public class ModuleQuestionAnswerServiceImpl implements ModuleQuestionAnswerServiceI {

    @Inject
    ModuleQuestionAnswersRepository moduleQuestionAnswersRepository;
    @Inject
    QuestionsAnswerRepository questionsAnswerRepository;
    @Inject
    ModulesRepository modulesRepository;

    @Override
    public ModuleQuestionsAnswers addQuestionAnswersToModule(ModuleQuestionsAnswersBean moduleQuestionsAnswersBean) throws BaseException {
        try {
            Modules module = modulesRepository.findOne(moduleQuestionsAnswersBean.getModuleId());
            QuestionsAnswer questionsAnswer = questionsAnswerRepository.findOne(moduleQuestionsAnswersBean.getQuestionsAnswerId());

            ModuleIdQuestionsAnswersId moduleIdQuestionsAnswersId = new ModuleIdQuestionsAnswersId(questionsAnswer, module);
            ModuleQuestionsAnswers moduleQuestionsAnswers = new ModuleQuestionsAnswers(moduleIdQuestionsAnswersId, moduleQuestionsAnswersBean.getIndexing());
            return moduleQuestionAnswersRepository.save(moduleQuestionsAnswers);
        } catch (Exception ex) {
            ErrorConstants err = ErrorConstants.DATA_PERSISTANT_EXCEPTION;
            throw new BaseException(err.errorCode, err.errorMessage, ex.getCause());
        }
    }
}