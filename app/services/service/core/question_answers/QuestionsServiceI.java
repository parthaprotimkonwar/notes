package services.service.core.question_answers;

import application.exceptions.BaseException;
import models.bean.core.question_answers.QuestionsBean;
import models.core.question_answers.Questions;

import java.util.List;

/**
 * Created by pkonwar on 4/17/2016.
 */
public interface QuestionsServiceI {

    Questions addQuestion(QuestionsBean questionsBean) throws BaseException;

    Questions addQuestion(Questions questions) throws BaseException;

    Questions findQuestion(Long questionId) throws BaseException;

    List<Questions> findAllQuestions() throws BaseException;

    Questions updateQuestion(QuestionsBean questionsBean) throws BaseException;

    void deleteQuestions(Long questionId) throws BaseException;

    List<QuestionsBean> convertToQuestionsBean(List<Questions> questions) throws BaseException;
}
