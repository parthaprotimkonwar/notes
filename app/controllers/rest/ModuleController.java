package controllers.rest;

import application.exceptions.BaseException;
import controllers.base.BaseController;
import controllers.responsedto.ErrorResponse;
import models.bean.core.ModulesBean;
import models.bean.core.SubjectsBean;
import models.core.Modules;
import models.core.Subjects;
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
public class ModuleController extends BaseController{

    @Inject
    ServicesFactory servicesFactory;

    public Result modules() {

        List<ModulesBean> modulesBeansList = null;
        try {
            List<Modules> availableModules = servicesFactory.modulesService.findAllModules();
            modulesBeansList = servicesFactory.modulesService.convertToModuleBean(availableModules);
        } catch (BaseException ex) {
            ErrorResponse errorResponse = new ErrorResponse(ex.getErrorCode(), ex.getErrorMessage());
            return errorObjectToJsonResponse(errorResponse);
        } catch (Exception e) {
            ErrorResponse errorResponse = unknownErrorResponse();
            return errorObjectToJsonResponse(errorResponse);
        }
        return convertObjectToJsonResponse(modulesBeansList);
    }
}
