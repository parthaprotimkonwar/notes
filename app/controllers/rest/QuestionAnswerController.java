package controllers.rest;

import application.exceptions.BaseException;
import controllers.base.BaseController;
import controllers.responsedto.ErrorResponse;
import controllers.responsedto.QuestionAnswersResponseDto;
import models.core.question_answers.ModuleQuestionsAnswers;
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

    public Result questionAnswers(Long moduleId) {

        List<QuestionAnswersResponseDto> questionAnswersResponseDtoList = null;
        try {
            List<ModuleQuestionsAnswers> moduleQuestionsAnswers = servicesFactory.moduleQuestionAnswerService.findQuestionAnswersFromAModule(moduleId);
            questionAnswersResponseDtoList = servicesFactory.questionAnswerService.generateQuestionAnswers(moduleQuestionsAnswers);
        } catch (BaseException ex) {
            ErrorResponse errorResponse = new ErrorResponse(ex.getErrorCode(), ex.getErrorMessage());
            return errorObjectToJsonResponse(errorResponse);
        } catch (Exception e) {
            ErrorResponse errorResponse = unknownErrorResponse();
            return errorObjectToJsonResponse(errorResponse);
        }
        return convertObjectToJsonResponse(questionAnswersResponseDtoList);
    }
}
