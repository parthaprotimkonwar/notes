package controllers.rest;

import application.exceptions.BaseException;
import controllers.base.BaseController;
import controllers.dto.QuestionAnswerDto;
import controllers.responsedto.ErrorResponse;
import controllers.responsedto.QuestionAnswersResponseDto;
import models.bean.core.question_answers.ModuleQuestionsAnswersBean;
import models.bean.core.question_answers.QuestionsBean;
import models.core.question_answers.ModuleQuestionsAnswers;
import models.core.question_answers.Questions;
import play.mvc.Result;
import services.service.impl.ServicesFactory;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import java.util.List;

/**
 * Created by pkonwar on 4/19/2016.
 */
@Named
@Singleton
public class QuestionAnswerController extends BaseController {


    @Inject
    ServicesFactory servicesFactory;

    /**
     * Get Question Answers QuestionAnswer QuestionModule ModuleQuestionAnswer for a specific module.
     * @param moduleId
     * @return
     */
    public Result questionAnswers(Long moduleId) {

        QuestionAnswerDto questionAnswersDto = null;
        try {
            List<ModuleQuestionsAnswers> moduleQuestionsAnswers = servicesFactory.moduleQuestionAnswerService.findQuestionAnswersFromAModule(moduleId);
            //Get Question Answers QuestionAnswer QuestionOptions
            questionAnswersDto = servicesFactory.questionAnswerService.generateQuestionAnswers(moduleQuestionsAnswers);

            List<ModuleQuestionsAnswersBean> moduleQuestionsAnswersBeanList = servicesFactory.moduleQuestionAnswerService.convertToModuleQuestionAnswerBean(moduleQuestionsAnswers);
            //adding module question answer bean list
            questionAnswersDto.setModuleQuestionAnswer(moduleQuestionsAnswersBeanList);

        } catch (BaseException ex) {
            ErrorResponse errorResponse = new ErrorResponse(ex.getErrorCode(), ex.getErrorMessage());
            return errorObjectToJsonResponse(errorResponse);
        } catch (Exception e) {
            ErrorResponse errorResponse = unknownErrorResponse();
            return errorObjectToJsonResponse(errorResponse);
        }
        return convertObjectToJsonResponse(questionAnswersDto);
    }

    public Result getQuestions() {
        List<QuestionsBean> questionResponseBean = null;
        try {
            List<Questions> questionsList  = servicesFactory.questionsService.findAllQuestions();
            questionResponseBean = servicesFactory.questionsService.convertToQuestionsBean(questionsList);
        } catch (BaseException ex) {
            ErrorResponse errorResponse = new ErrorResponse(ex.getErrorCode(), ex.getErrorMessage());
            return errorObjectToJsonResponse(errorResponse);
        } catch (Exception e) {
            ErrorResponse errorResponse = unknownErrorResponse();
            return errorObjectToJsonResponse(errorResponse);
        }
        return convertObjectToJsonResponse(questionResponseBean);
    }
}
