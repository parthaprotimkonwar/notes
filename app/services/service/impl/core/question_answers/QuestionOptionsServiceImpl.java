package services.service.impl.core.question_answers;

import application.exceptions.BaseException;
import application.exceptions.ErrorConstants;
import application.utilities.Util;
import models.bean.core.question_answers.QuestionOptionsBean;
import models.core.question_answers.QuestionOptions;
import models.core.question_answers.Questions;
import repository.core.question_answers.QuestionOptionsRepository;
import repository.core.question_answers.QuestionsRepository;
import services.service.core.question_answers.QuestionOptionsServiceI;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pkonwar on 4/18/2016.
 */
@Named
@Singleton
public class QuestionOptionsServiceImpl implements QuestionOptionsServiceI{

    @Inject
    QuestionsRepository questionsRepository;
    @Inject
    QuestionOptionsRepository questionOptionsRepository;

    @Override
    public QuestionOptions addQuestionOptions(QuestionOptionsBean questionOptionsBean) throws BaseException {
        try {
            Questions question = questionsRepository.findOne(questionOptionsBean.getQuestionId());
            QuestionOptions questionOptions = new QuestionOptions(question, questionOptionsBean.getOption1(), questionOptionsBean.getOption2(), questionOptionsBean.getOption3(), questionOptionsBean.getOption4(), questionOptionsBean.getAdditionalOptions());
            return questionOptionsRepository.save(questionOptions);
        } catch (Exception ex) {
            ErrorConstants err = ErrorConstants.DATA_PERSISTANT_EXCEPTION;
            throw new BaseException(err.errorCode, err.errorMessage, ex.getCause());
        }
    }

    @Override
    public QuestionOptions updateQuestionOptions(QuestionOptionsBean questionOptionsBean) throws BaseException {
        try {
            QuestionOptions questionOptions = questionOptionsRepository.findOne(questionOptionsBean.getQuestionOptionsId());
            if(Util.notNull(questionOptionsBean.getOption1()))
                questionOptions.setOption1(questionOptionsBean.getOption1());
            if(Util.notNull(questionOptionsBean.getOption2()))
                questionOptions.setOption2(questionOptionsBean.getOption2());
            if(Util.notNull(questionOptionsBean.getOption3()))
                questionOptions.setOption3(questionOptionsBean.getOption3());
            if(Util.notNull(questionOptionsBean.getOption4()))
                questionOptions.setOption4(questionOptionsBean.getOption4());
            if(Util.notNull(questionOptionsBean.getAdditionalOptions()))
                questionOptions.setAdditionalOptions(questionOptionsBean.getAdditionalOptions());

            return questionOptionsRepository.save(questionOptions);
        } catch (Exception ex) {
            ErrorConstants err = ErrorConstants.DATA_UPDATION_EXCEPTION;
            throw new BaseException(err.errorCode, err.errorMessage, ex.getCause());
        }
    }

    @Override
    public void deleteQuestionOptions(Long questionOptionsId) throws BaseException {
        try {
            QuestionOptions questionOptions = questionOptionsRepository.findOne(questionOptionsId);
            questionOptionsRepository.delete(questionOptions);
        } catch (Exception ex) {
            ErrorConstants err = ErrorConstants.DATA_REMOVAL_EXCEPTION;
            throw new BaseException(err.errorCode, err.errorMessage, ex.getCause());
        }
    }

    @Override
    public List<QuestionOptionsBean> convertToQuestionOptions(List<QuestionOptions> questionOptionsList) throws BaseException {
        List<QuestionOptionsBean> questionOptionsBeanList = new ArrayList<>();
        for(QuestionOptions questionOptions : questionOptionsList) {
            questionOptionsBeanList.add(new QuestionOptionsBean(questionOptions.getQuestionOptionsId(), questionOptions.getQuestion().getQuestionId(), questionOptions.getOption1(), questionOptions.getOption2(), questionOptions.getOption3(), questionOptions.getOption4(), questionOptions.getAdditionalOptions()));
        }
        return questionOptionsBeanList;
    }
}
