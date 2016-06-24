package controllers.rest;

import application.enums.STATUS;
import application.exceptions.BaseException;
import controllers.base.BaseController;
import controllers.requestdto.ModuleQuestionAnswerDto;
import controllers.responsedto.BaseResponseDto;
import controllers.responsedto.ErrorResponse;
import models.bean.core.ChaptersBean;
import models.bean.core.SubjectsBean;
import models.core.Chapters;
import models.core.Modules;
import models.core.Subjects;
import models.core.question_answers.*;
import play.mvc.Result;
import services.service.impl.ServicesFactory;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pkonwar on 6/24/2016.
 */
@Named
@Singleton
public class AdminUserController extends BaseController{

    @Inject
    private ServicesFactory servicesFactory;


    public Result addSubject() {

        SubjectsBean subjectsBean = null;
        try {
            subjectsBean = convertRequestBodyToObject(request().body(), SubjectsBean.class);
            Subjects subject = servicesFactory.subjectsService.addSubject(subjectsBean);
            subjectsBean = subject.toSubjectBean();

        } catch (BaseException ex) {
            ErrorResponse errorResponse = new ErrorResponse(ex.getErrorCode(), ex.getErrorMessage());
            return errorObjectToJsonResponse(errorResponse);
        } catch (Exception e) {
            ErrorResponse errorResponse = unknownErrorResponse();
            return errorObjectToJsonResponse(errorResponse);
        }
        return convertObjectToJsonResponse(subjectsBean);
    }

    public Result addChapter(){

        ChaptersBean chaptersBean = null;
        try {
            chaptersBean = convertRequestBodyToObject(request().body(), ChaptersBean.class);
            //adds a new chapter
            Chapters chapters = servicesFactory.chaptersService.addChapter(chaptersBean);
            //add a default module for this chapter
            servicesFactory.modulesService.addDefaultModule(chapters);
            chaptersBean = chapters.toChapterBean();
        } catch (BaseException ex) {
            ErrorResponse errorResponse = new ErrorResponse(ex.getErrorCode(), ex.getErrorMessage());
            return errorObjectToJsonResponse(errorResponse);
        } catch (Exception e) {
            ErrorResponse errorResponse = unknownErrorResponse();
            return errorObjectToJsonResponse(errorResponse);
        }
        return convertObjectToJsonResponse(chaptersBean);
    }

    public Result addQuestionAnswers() {

        BaseResponseDto responseDto = null;
        try {
            ModuleQuestionAnswerDto moduleQuestionAnswerDto = convertRequestBodyToObject(request().body(), ModuleQuestionAnswerDto.class);
            servicesFactory.moduleQuestionAnswerService.addQuestionAnswersToModule(moduleQuestionAnswerDto);
            responseDto = new BaseResponseDto("token", STATUS.SUCCESS.name());
        } catch (BaseException ex) {
            ErrorResponse errorResponse = new ErrorResponse(ex.getErrorCode(), ex.getErrorMessage());
            return errorObjectToJsonResponse(errorResponse);
        } catch (Exception e) {
            ErrorResponse errorResponse = unknownErrorResponse();
            return errorObjectToJsonResponse(errorResponse);
        }
        return convertObjectToJsonResponse(responseDto);
    }


    public Result getAllSubjects() {

        List<SubjectsBean> subjectsBeanList;
        try {
            List<Subjects> subjectsList = servicesFactory.subjectsService.findAllSubjects();
            subjectsBeanList = servicesFactory.subjectsService.convertToSubjectBean(subjectsList);
        } catch (BaseException ex) {
            ErrorResponse errorResponse = new ErrorResponse(ex.getErrorCode(), ex.getErrorMessage());
            return errorObjectToJsonResponse(errorResponse);
        } catch (Exception e) {
            ErrorResponse errorResponse = unknownErrorResponse();
            return errorObjectToJsonResponse(errorResponse);
        }
        return convertObjectToJsonResponse(subjectsBeanList);
    }


    public Result getAllChapters(long subjectId) {
        List<ChaptersBean> chaptersBeanList;
        try {
            List<Chapters> chaptersList = servicesFactory.chaptersService.findAllChaptersBySubject(subjectId);
            chaptersBeanList = servicesFactory.chaptersService.convertToChapterBean(chaptersList);
        } catch (BaseException ex) {
            ErrorResponse errorResponse = new ErrorResponse(ex.getErrorCode(), ex.getErrorMessage());
            return errorObjectToJsonResponse(errorResponse);
        } catch (Exception e) {
            ErrorResponse errorResponse = unknownErrorResponse();
            return errorObjectToJsonResponse(errorResponse);
        }
        return convertObjectToJsonResponse(chaptersBeanList);
    }

    public Result getAllQuestionAnswer(long chapterId) {

        List<ModuleQuestionAnswerDto> moduleQuestionAnswerDtoList = new ArrayList<>();
        try {
            Modules modules = servicesFactory.modulesService.findDefaultModule(chapterId);
            List<ModuleQuestionsAnswers> moduleQuestionsAnswersList = servicesFactory.moduleQuestionAnswerService.findQuestionAnswersFromAModule(modules.getModuleId());

            for(ModuleQuestionsAnswers moduleQuestionsAnswers : moduleQuestionsAnswersList) {
                Long questionAnswerId = moduleQuestionsAnswers.getModuleIdQuestionsAnswersId().getQuestionsAnswer().getQuestionAnswerId();
                String question = moduleQuestionsAnswers.getModuleIdQuestionsAnswersId().getQuestionsAnswer().getQuestion().getQuestion();
                String answer = moduleQuestionsAnswers.getModuleIdQuestionsAnswersId().getQuestionsAnswer().getAnswer().getAnswer();
                Integer indexing = moduleQuestionsAnswers.getIndexing();
                ModuleQuestionAnswerDto moduleQuestionAnswerDto = new ModuleQuestionAnswerDto(questionAnswerId, modules.getModuleId(), question, answer, indexing);

                //add question answer to list
                moduleQuestionAnswerDtoList.add(moduleQuestionAnswerDto);
            }

        } catch (BaseException ex) {
            ErrorResponse errorResponse = new ErrorResponse(ex.getErrorCode(), ex.getErrorMessage());
            return errorObjectToJsonResponse(errorResponse);
        } catch (Exception e) {
            ErrorResponse errorResponse = unknownErrorResponse();
            return errorObjectToJsonResponse(errorResponse);
        }
        return convertObjectToJsonResponse(moduleQuestionAnswerDtoList);

    }
}
