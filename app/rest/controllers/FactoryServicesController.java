package rest.controllers;

import application.exceptions.BaseException;
import rest.base.BaseController;
import rest.dto.CoreFactoryDto;
import rest.responsedto.ErrorResponse;
import models.bean.core.*;
import models.core.*;
import play.mvc.Result;
import services.service.impl.ServicesFactory;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import java.util.List;

/**
 * Created by pkonwar on 5/1/2016.
 */
@Named
@Singleton
public class FactoryServicesController extends BaseController {

    @Inject
    ServicesFactory servicesFactory;

    /**
     * Get the Subjects, Chapters, Modules, Authors, SubjectAuthor data.
     * @return
     */
    public Result coreFactorySettingsData() {
        CoreFactoryDto coreFactoryDto = new CoreFactoryDto();

        try {
            //get all Courses/Subject
            List<Subjects> availableSubjects = servicesFactory.subjectsService.findAllSubjects();
            List<SubjectsBean> subjectsBeanList = servicesFactory.subjectsService.convertToSubjectBean(availableSubjects);

            //get all Chapters
            List<Chapters> chaptersList = servicesFactory.chaptersService.findAllChapters();
            List<ChaptersBean> chaptersBeansList = servicesFactory.chaptersService.convertToChapterBean(chaptersList);

            //get all Modules
            List<Modules> availableModules = servicesFactory.modulesService.findAllModules();
            List<ModulesBean> modulesBeansList = servicesFactory.modulesService.convertToModuleBean(availableModules);

            //get all Authors
            List<Authors> authorsList = servicesFactory.authorsService.findAllAuthors();
            List<AuthorsBean> authorsBeansList = servicesFactory.authorsService.convertToAuthorsBean(authorsList);

            //get all subject authors
            List<SubjectAuthor> subjectAuthorList = servicesFactory.subjectAuthorService.findAllSubjectAuthor();
            List<SubjectAuthorBean> subjectAuthorBeanList = servicesFactory.subjectAuthorService.convertToSubjectAuthorBean(subjectAuthorList);

            //set properties to factory dto for parcel
            coreFactoryDto.setSubjects(subjectsBeanList);
            coreFactoryDto.setChapters(chaptersBeansList);
            coreFactoryDto.setModules(modulesBeansList);
            coreFactoryDto.setAuthors(authorsBeansList);
            coreFactoryDto.setSubjectAuthor(subjectAuthorBeanList);

        } catch (BaseException ex) {
            ErrorResponse errorResponse = new ErrorResponse(ex.getErrorCode(), ex.getErrorMessage());
            return errorObjectToJsonResponse(errorResponse);
        } catch (Exception e) {
            ErrorResponse errorResponse = unknownErrorResponse();
            return errorObjectToJsonResponse(errorResponse);
        }
        return convertObjectToJsonResponse(coreFactoryDto);
    }

}
