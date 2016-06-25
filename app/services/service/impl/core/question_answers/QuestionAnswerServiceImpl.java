package services.service.impl.core.question_answers;

import application.exceptions.BaseException;
import application.exceptions.ErrorConstants;
import rest.dto.QuestionAnswerDto;
import models.bean.core.question_answers.AnswersBean;
import models.bean.core.question_answers.QuestionOptionsBean;
import models.bean.core.question_answers.QuestionsAnswerBean;
import models.bean.core.question_answers.QuestionsBean;
import models.core.question_answers.*;
import repository.core.question_answers.AnswersRepository;
import repository.core.question_answers.QuestionsAnswerRepository;
import repository.core.question_answers.QuestionsRepository;
import services.service.core.question_answers.QuestionAnswerServiceI;

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
public class QuestionAnswerServiceImpl implements QuestionAnswerServiceI {

    @Inject
    QuestionsRepository questionsRepository;
    @Inject
    AnswersRepository answersRepository;
    @Inject
    QuestionsAnswerRepository questionsAnswerRepository;

    @Override
    public QuestionsAnswer addQuestionAnswer(QuestionsAnswerBean questionsAnswerBean) throws BaseException {
        try {
            Questions question = questionsRepository.findOne(questionsAnswerBean.getQuestionId());
            Answers answer = answersRepository.findOne(questionsAnswerBean.getAnswerId());

            QuestionsAnswer questionsAnswer = new QuestionsAnswer(question, answer, questionsAnswerBean.getType());
            return questionsAnswerRepository.save(questionsAnswer);
        } catch (Exception ex) {
            ErrorConstants err = ErrorConstants.DATA_PERSISTANT_EXCEPTION;
            throw new BaseException(err.errorCode, err.errorMessage, ex.getCause());
        }
    }

    @Override
    public QuestionsAnswer addQuestionAnswer(QuestionsAnswer questionsAnswer) throws BaseException {
        try {
            return questionsAnswerRepository.save(questionsAnswer);
        } catch (Exception ex) {
            ErrorConstants err = ErrorConstants.DATA_PERSISTANT_EXCEPTION;
            throw new BaseException(err.errorCode, err.errorMessage, ex.getCause());
        }
    }

    @Override
    public QuestionAnswerDto generateQuestionAnswers(List<ModuleQuestionsAnswers> moduleQuestionsAnswersList) throws BaseException{
        try {
            QuestionAnswerDto questionAnswerDto = new QuestionAnswerDto();
            for(ModuleQuestionsAnswers moduleQuestionsAnswers : moduleQuestionsAnswersList) {

                QuestionsAnswer questionsAnswer = moduleQuestionsAnswers.getModuleIdQuestionsAnswersId().getQuestionsAnswer();
                Questions question = questionsAnswer.getQuestion();
                Answers answers = questionsAnswer.getAnswer();
                QuestionOptions questionOptions = question.getQuestionOptions();

                //adding QuestionAnswer
                if(questionsAnswer != null)
                    questionAnswerDto.getQuestionAnswer().add(new QuestionsAnswerBean(questionsAnswer.getQuestionAnswerId(), question.getQuestionId(), answers.getAnswerId(), questionsAnswer.getType()));
                //adding question
                if(question != null)
                    questionAnswerDto.getQuestions().add(new QuestionsBean(question.getQuestionId(), question.getQuestion()));
                //adding answer
                if(answers != null)
                    questionAnswerDto.getAnswers().add(new AnswersBean(answers.getAnswerId(), answers.getAnswer()));
                //adding questions options
                if(questionOptions != null)
                    questionAnswerDto.getQuestionOptions().add(new QuestionOptionsBean(questionOptions.getQuestionOptionsId(), questionOptions.getQuestion().getQuestionId(), questionOptions.getOption1(), questionOptions.getOption2(), questionOptions.getOption3(), questionOptions.getOption4(), questionOptions.getAdditionalOptions()));
            }
            return questionAnswerDto;
        } catch (Exception ex) {
            ErrorConstants err = ErrorConstants.DATA_FETCH_EXCEPTION;
            throw new BaseException(err.errorCode, err.errorMessage, ex.getCause());
        }
    }

    @Override
    public List<QuestionsAnswerBean> convertToQuestionAnswersBean(List<QuestionsAnswer> questionsAnswerList) throws BaseException {
        List<QuestionsAnswerBean> questionsAnswerBeanList = new ArrayList<>();
        for(QuestionsAnswer questionsAnswer : questionsAnswerList) {
            Questions question = questionsAnswer.getQuestion();
            Answers answers = questionsAnswer.getAnswer();
            questionsAnswerBeanList.add(new QuestionsAnswerBean(questionsAnswer.getQuestionAnswerId(), question.getQuestionId(), answers.getAnswerId(), questionsAnswer.getType()));
        }
        return questionsAnswerBeanList;
    }
}
