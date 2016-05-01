package services.service.core.question_answers;

import application.exceptions.BaseException;
import models.bean.core.question_answers.QuestionOptionsBean;
import models.core.question_answers.QuestionOptions;

import java.util.List;

/**
 * Created by pkonwar on 4/18/2016.
 */
public interface QuestionOptionsServiceI {

    /**
     * Add Options for Questions
     * @param questionOptionsBean
     * @return
     * @throws BaseException
     */
    QuestionOptions addQuestionOptions(QuestionOptionsBean questionOptionsBean) throws BaseException;

    /**
     * Update the options for questions
     * @param questionOptionsBean
     * @return
     * @throws BaseException
     */
    QuestionOptions updateQuestionOptions(QuestionOptionsBean questionOptionsBean) throws BaseException;

    /**
     * Delete options for Question
     * @param questionOptionsId
     * @return
     * @throws BaseException
     */
    void deleteQuestionOptions(Long questionOptionsId) throws BaseException;

    /**
     * Convert to Questins Options Bean
     * @param questionOptions
     * @return
     * @throws BaseException
     */
    List<QuestionOptionsBean> convertToQuestionOptions(List<QuestionOptions> questionOptions) throws BaseException;
}
