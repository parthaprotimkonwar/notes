package services.service.impl.core.question_answers;

import application.enums.QA_TYPE;
import application.exceptions.BaseException;
import application.exceptions.ErrorConstants;
import controllers.requestdto.ModuleQuestionAnswerDto;
import models.bean.core.question_answers.ModuleQuestionsAnswersBean;
import models.core.Modules;
import models.core.question_answers.*;
import org.springframework.transaction.annotation.Transactional;
import repository.core.ModulesRepository;
import repository.core.question_answers.AnswersRepository;
import repository.core.question_answers.ModuleQuestionAnswersRepository;
import repository.core.question_answers.QuestionsAnswerRepository;
import repository.core.question_answers.QuestionsRepository;
import services.service.core.ModulesServiceI;
import services.service.core.question_answers.ModuleQuestionAnswerServiceI;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pkonwar on 4/17/2016.
 */
@Named
@Singleton
@Transactional
public class ModuleQuestionAnswerServiceImpl implements ModuleQuestionAnswerServiceI {

    @Inject
    ModuleQuestionAnswersRepository moduleQuestionAnswersRepository;
    @Inject
    QuestionsAnswerRepository questionsAnswerRepository;
    @Inject
    ModulesRepository modulesRepository;
    @Inject
    QuestionsRepository questionsRepository;
    @Inject
    AnswersRepository answersRepository;
    @Inject
    ModulesServiceI modulesServiceI;

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

    @Override
    public ModuleQuestionsAnswers addQuestionAnswersToModule(ModuleQuestionsAnswers moduleQuestionsAnswers) throws BaseException {
        try {
            return moduleQuestionAnswersRepository.save(moduleQuestionsAnswers);
        } catch (Exception ex) {
            ErrorConstants err = ErrorConstants.DATA_PERSISTANT_EXCEPTION;
            throw new BaseException(err.errorCode, err.errorMessage, ex.getCause());
        }
    }

    @Override
    public ModuleQuestionsAnswers addQuestionAnswersToModule(ModuleQuestionAnswerDto moduleQuestionAnswerDto) throws BaseException {
        try {
            //add new question
            Questions question = new Questions(moduleQuestionAnswerDto.getQuestion());
            question = questionsRepository.save(question);

            //add new answer
            Answers answer = new Answers(moduleQuestionAnswerDto.getAnswer());
            answer = answersRepository.save(answer);

            //add new question answer
            QuestionsAnswer questionsAnswer = new QuestionsAnswer(question, answer, QA_TYPE.SHORT);
            questionsAnswerRepository.save(questionsAnswer);

            //link modules and question answers with the default module of the chapter
            Modules modules = modulesServiceI.findDefaultModule(moduleQuestionAnswerDto.getChapterId());
            ModuleQuestionsAnswers moduleQuestionsAnswers = new ModuleQuestionsAnswers(new ModuleIdQuestionsAnswersId(questionsAnswer, modules), moduleQuestionAnswerDto.getIndexing());
            return moduleQuestionAnswersRepository.save(moduleQuestionsAnswers);
        } catch (Exception ex){
            ErrorConstants err = ErrorConstants.DATA_PERSISTANT_EXCEPTION;
            throw new BaseException(err.errorCode, err.errorMessage, ex.getCause());
        }

    }

    @Override
    public List<ModuleQuestionsAnswers> findQuestionAnswersFromAModule(Long moduleId) throws BaseException {
        try {
            Modules module = modulesRepository.findOne(moduleId);
            return moduleQuestionAnswersRepository.findByModuleIdQuestionsAnswersIdModule(module);
        } catch (Exception ex) {
            ErrorConstants err = ErrorConstants.DATA_FETCH_EXCEPTION;
            throw new BaseException(err.errorCode, err.errorMessage, ex.getCause());
        }
    }

    @Override
    public List<ModuleQuestionsAnswersBean> convertToModuleQuestionAnswerBean(List<ModuleQuestionsAnswers> moduleQuestionsAnswersList) throws BaseException {
        List<ModuleQuestionsAnswersBean> moduleQuestionsAnswersBeanList = new ArrayList<>();
        for(ModuleQuestionsAnswers moduleQuestionsAnswers : moduleQuestionsAnswersList) {
            moduleQuestionsAnswersBeanList.add(new ModuleQuestionsAnswersBean(moduleQuestionsAnswers.getModuleIdQuestionsAnswersId().getQuestionsAnswer().getQuestionAnswerId(), moduleQuestionsAnswers.getModuleIdQuestionsAnswersId().getModule().getModuleId(), moduleQuestionsAnswers.getIndexing()));
        }
        return moduleQuestionsAnswersBeanList;
    }
}
