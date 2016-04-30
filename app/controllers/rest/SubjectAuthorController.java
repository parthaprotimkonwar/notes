package controllers.rest;

import application.exceptions.BaseException;
import controllers.base.BaseController;
import controllers.responsedto.ErrorResponse;
import models.bean.core.AuthorsBean;
import models.core.Authors;
import play.mvc.Result;
import services.service.impl.ServicesFactory;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import java.util.List;

/**
 * Created by pkonwar on 4/30/2016.
 */
@Named
@Singleton
public class SubjectAuthorController extends BaseController{

    @Inject
    ServicesFactory servicesFactory;

    public Result subjectAuthor() {
        List<AuthorsBean> authorsBeans = null;
        try {
            List<Authors> authorsList = servicesFactory.authorsService.findAllAuthors();
            authorsBeans = servicesFactory.authorsService.convertToAuthorsBean(authorsList);
        } catch (BaseException ex) {
            ErrorResponse errorResponse = new ErrorResponse(ex.getErrorCode(), ex.getErrorMessage());
            return errorObjectToJsonResponse(errorResponse);
        } catch (Exception e) {
            ErrorResponse errorResponse = unknownErrorResponse();
            return errorObjectToJsonResponse(errorResponse);
        }
        return convertObjectToJsonResponse(authorsBeans);
    }
}
