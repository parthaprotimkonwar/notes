package services.service.impl.core.question_answers;

import application.exceptions.BaseException;
import application.exceptions.ErrorConstants;
import com.fasterxml.jackson.databind.deser.Deserializers;
import models.bean.core.question_answers.AnswersBean;
import models.core.question_answers.Answers;
import repository.core.question_answers.AnswersRepository;
import services.service.core.question_answers.AnswersServiceI;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

/**
 * Created by pkonwar on 4/17/2016.
 */
@Named
@Singleton
public class AnswerServiceImpl implements AnswersServiceI{

    @Inject
    AnswersRepository answersRepository;

    @Override
    public Answers addAnswers(AnswersBean answersBean) throws BaseException {
        try {
            Answers answers = new Answers(answersBean.getAnswer());
            return answersRepository.save(answers);
        } catch (Exception ex) {
            ErrorConstants err = ErrorConstants.DATA_PERSISTANT_EXCEPTION;
            throw new BaseException(err.errorCode, err.errorMessage, ex.getCause());
        }
    }

    @Override
    public Answers updateAnswers(AnswersBean answersBean) throws BaseException {
        try {
            Answers answers = answersRepository.findOne(answersBean.getAnswerId());
            answers.setAnswer(answersBean.getAnswer());
            return answersRepository.save(answers);
        } catch (Exception ex) {
            ErrorConstants err = ErrorConstants.DATA_UPDATION_EXCEPTION;
            throw new BaseException(err.errorCode, err.errorMessage, ex.getCause());
        }
    }

    @Override
    public Answers findAnswers(Long answerId) throws BaseException {
        try {
            return answersRepository.findOne(answerId);
        } catch (Exception ex) {
            ErrorConstants err = ErrorConstants.DATA_FETCH_EXCEPTION;
            throw new BaseException(err.errorCode, err.errorMessage, ex.getCause());
        }
    }

    @Override
    public void deleteAnswers(Long answerId) throws BaseException {
        try {
            answersRepository.delete(answerId);
        } catch (Exception ex) {
            ErrorConstants err = ErrorConstants.DATA_REMOVAL_EXCEPTION;
            throw new BaseException(err.errorCode, err.errorMessage, ex.getCause());
        }
    }
}
