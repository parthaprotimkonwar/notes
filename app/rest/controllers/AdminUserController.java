package rest.controllers;

import application.enums.STATUS;
import application.exceptions.BaseException;
import rest.base.BaseController;
import rest.requestdto.ModuleQuestionAnswerDto;
import rest.responsedto.ErrorResponse;
import rest.responsedto.GenericResponseContainer;
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
        return convertObjectToJsonResponse(new GenericResponseContainer(STATUS.SUCCESS.name(), subjectsBean));
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
        return convertObjectToJsonResponse(new GenericResponseContainer(STATUS.SUCCESS.name(), chaptersBean));
    }

    public Result addQuestionAnswers() {

        try {
            ModuleQuestionAnswerDto moduleQuestionAnswerDto = convertRequestBodyToObject(request().body(), ModuleQuestionAnswerDto.class);
            servicesFactory.moduleQuestionAnswerService.addQuestionAnswersToModule(moduleQuestionAnswerDto);
        } catch (BaseException ex) {
            ErrorResponse errorResponse = new ErrorResponse(ex.getErrorCode(), ex.getErrorMessage());
            return errorObjectToJsonResponse(errorResponse);
        } catch (Exception e) {
            ErrorResponse errorResponse = unknownErrorResponse();
            return errorObjectToJsonResponse(errorResponse);
        }
        return convertObjectToJsonResponse(new GenericResponseContainer(STATUS.SUCCESS.name(), null));
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
        return convertObjectToJsonResponse(new GenericResponseContainer(STATUS.SUCCESS.name(), subjectsBeanList));
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
        return convertObjectToJsonResponse(new GenericResponseContainer(STATUS.SUCCESS.name(), chaptersBeanList));
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
                ModuleQuestionAnswerDto moduleQuestionAnswerDto = new ModuleQuestionAnswerDto(questionAnswerId, modules.getModuleId(), question, answer, indexing, chapterId);

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
        return convertObjectToJsonResponse(new GenericResponseContainer(STATUS.SUCCESS.name(), moduleQuestionAnswerDtoList));
    }
}
