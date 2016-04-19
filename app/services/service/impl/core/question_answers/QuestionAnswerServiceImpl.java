package services.service.impl.core.question_answers;

import application.enums.QA_TYPE;
import application.exceptions.BaseException;
import application.exceptions.ErrorConstants;
import controllers.responsedto.QuestionAnswersResponseDto;
import models.bean.core.question_answers.QuestionsAnswerBean;
import models.core.question_answers.Answers;
import models.core.question_answers.ModuleQuestionsAnswers;
import models.core.question_answers.Questions;
import models.core.question_answers.QuestionsAnswer;
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
    public List<QuestionAnswersResponseDto> generateQuestionAnswers(List<ModuleQuestionsAnswers> moduleQuestionsAnswersList) throws BaseException{
        try {
            List<QuestionAnswersResponseDto> questionAnswersResponseDtoList = new ArrayList<>();
            for(ModuleQuestionsAnswers moduleQuestionsAnswers : moduleQuestionsAnswersList) {
                QuestionsAnswer questionsAnswer = moduleQuestionsAnswers.getModuleIdQuestionsAnswersId().getQuestionsAnswer();
                Questions question = questionsAnswer.getQuestion();
                Answers answers = questionsAnswer.getAnswer();
                QA_TYPE qaType = questionsAnswer.getType();
                questionAnswersResponseDtoList.add(new QuestionAnswersResponseDto(question.getQuestion(), answers.getAnswer(), qaType, null));
            }
            return questionAnswersResponseDtoList;
        } catch (Exception ex) {
            ErrorConstants err = ErrorConstants.DATA_PERSISTANT_EXCEPTION;
            throw new BaseException(err.errorCode, err.errorMessage, ex.getCause());
        }
    }
}
