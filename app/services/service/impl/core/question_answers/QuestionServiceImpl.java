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
import java.util.ArrayList;
import java.util.List;

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
    public Questions addQuestion(Questions questions) throws BaseException {
        try {
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
    public List<Questions> findAllQuestions() throws BaseException {
        try {
            return questionsRepository.findAll();
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

    @Override
    public List<QuestionsBean> convertToQuestionsBean(List<Questions> questions) throws BaseException {
        List<QuestionsBean> questionsBeanList = new ArrayList<>();
        for(Questions question : questions) {
            questionsBeanList.add(new QuestionsBean(question.getQuestionId(), question.getQuestion()));
        }
        return questionsBeanList;
    }
}
