package services.service.impl.core.question_answers;

import application.exceptions.BaseException;
import application.exceptions.ErrorConstants;
import models.bean.core.question_answers.QuestionsBean;
import models.core.question_answers.Questions;
import repository.core.question_answers.QuestionsRepository;
import services.service.core.question_answers.QuestionsServiceI;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

/**
 * Created by pkonwar on 4/17/2016.
 */
@Named
@Singleton
public class QuestionServiceImpl implements QuestionsServiceI {

    @Inject
    QuestionsRepository questionsRepository;

    @Override
    public Questions addQuestion(QuestionsBean questionsBean) throws BaseException {
        try {
            Questions questions = new Questions(questionsBean.getQuestion());
            return questionsRepository.save(questions);
        } catch (Exception ex) {
            ErrorConstants err = ErrorConstants.DATA_PERSISTANT_EXCEPTION;
            throw new BaseException(err.errorCode, err.errorMessage, ex.getCause());
        }
    }

    @Override
    public Questions findQuestion(Long questionId) throws BaseException {
        try {
            return questionsRepository.findOne(questionId);
        } catch (Exception ex) {
            ErrorConstants err = ErrorConstants.DATA_FETCH_EXCEPTION;
            throw new BaseException(err.errorCode, err.errorMessage, ex.getCause());
        }
    }

    @Override
    public Questions updateQuestion(QuestionsBean questionsBean) throws BaseException {
        try {
            Questions questions = questionsRepository.findOne(questionsBean.getQuestionId());
            questions.setQuestion(questionsBean.getQuestion());
            return questionsRepository.save(questions);
        } catch (Exception ex) {
            ErrorConstants err = ErrorConstants.DATA_UPDATION_EXCEPTION;
            throw new BaseException(err.errorCode, err.errorMessage, ex.getCause());
        }
    }

    @Override
    public void deleteQuestions(Long questionId) throws BaseException {
        try {
            questionsRepository.delete(questionId);
        } catch (Exception ex) {
            ErrorConstants err = ErrorConstants.DATA_REMOVAL_EXCEPTION;
            throw new BaseException(err.errorCode, err.errorMessage, ex.getCause());
        }
    }
}
