package services.service.core.question_answers;

import application.exceptions.BaseException;
import models.bean.core.question_answers.AnswersBean;
import models.core.question_answers.Answers;

import java.util.List;

/**
 * Created by pkonwar on 4/17/2016.
 */
public interface AnswersServiceI {

    /**
     * Add a new Answer
     * @param answersBean
     * @return
     * @throws BaseException
     */
    Answers addAnswers(AnswersBean answersBean) throws BaseException;

    /**
     *
     * @param answers
     * @return
     * @throws BaseException
     */
    Answers addAnswers(Answers answers) throws BaseException;

    /**
     * Update an Answer
     * @param answersBean
     * @return
     * @throws BaseException
     */
    Answers updateAnswers(AnswersBean answersBean) throws BaseException;

    /**
     * Find an Answer
     * @param answerId
     * @return
     * @throws BaseException
     */
    Answers findAnswers(Long answerId) throws BaseException;

    /**
     * Delete an Answer
     * @param answerId
     * @throws BaseException
     */
    void deleteAnswers(Long answerId) throws BaseException;

    /**
     * Converts to Answer Bean
     * @param answersList
     * @return
     * @throws BaseException
     */
    List<AnswersBean> convertToAnswersBean(List<Answers> answersList) throws BaseException;
}
