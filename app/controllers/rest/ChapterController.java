package controllers.rest;

import application.exceptions.BaseException;
import controllers.base.BaseController;
import controllers.responsedto.ErrorResponse;
import models.bean.core.ChaptersBean;
import models.core.Chapters;
import org.springframework.data.domain.Page;
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
public class ChapterController extends BaseController {

    @Inject
    private ServicesFactory servicesFactory;

    public Result chapters(Long subjectId) {

        List<ChaptersBean> chaptersBeans = null;
        try {
            //SubjectsBean subjectsBean = convertRequestBodyToObject(request().body(), SubjectsBean.class);
            System.out.println(subjectId);
            List<Chapters> chaptersList = servicesFactory.chaptersServiceI.findAllChaptersBySubject(subjectId);
            chaptersBeans = servicesFactory.chaptersServiceI.convertToChapterBean(chaptersList);
        } catch (BaseException ex) {
            ErrorResponse errorResponse = new ErrorResponse(ex.getErrorCode(), ex.getErrorMessage());
            return errorObjectToJsonResponse(errorResponse);
        } catch (Exception e) {
            ErrorResponse errorResponse = unknownErrorResponse();
            return errorObjectToJsonResponse(errorResponse);
        }
        return convertObjectToJsonResponse(chaptersBeans);
    }
}
