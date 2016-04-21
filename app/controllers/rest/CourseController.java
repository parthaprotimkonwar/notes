package controllers.rest;

import application.exceptions.BaseException;
import controllers.base.BaseController;
import controllers.responsedto.ErrorResponse;
import models.bean.core.SubjectsBean;
import models.core.Subjects;
import play.mvc.Result;
import services.service.impl.ServicesFactory;
import startup.BootstrapCoreModules;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import java.util.List;

/**
 * Created by pkonwar on 4/19/2016.
 */
@Named
@Singleton
public class CourseController extends BaseController{

    @Inject
    ServicesFactory servicesFactory;

    public Result courses() {

        List<SubjectsBean> availableSubjectsBeans = null;
        try {
            List<Subjects> availableSubjects = servicesFactory.subjectsService.findAllSubjects();
            availableSubjectsBeans = servicesFactory.subjectsService.convertToSubjectBean(availableSubjects);
        } catch (BaseException ex) {
            ErrorResponse errorResponse = new ErrorResponse(ex.getErrorCode(), ex.getErrorMessage());
            return errorObjectToJsonResponse(errorResponse);
        } catch (Exception e) {
            ErrorResponse errorResponse = unknownErrorResponse();
            return errorObjectToJsonResponse(errorResponse);
        }
        return convertObjectToJsonResponse(availableSubjectsBeans);
    }
}
