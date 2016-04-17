package services.service.impl.core;

import application.enums.STATUS;
import application.exceptions.BaseException;
import application.exceptions.ErrorConstants;
import application.utilities.Util;
import models.bean.core.ChaptersBean;
import models.core.Chapters;
import models.core.Subjects;
import repository.core.ChaptersRepository;
import repository.core.SubjectsRepository;
import services.service.core.ChaptersServiceI;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import java.util.List;

/**
 * Created by pkonwar on 4/17/2016.
 */
@Named
@Singleton
public class ChaptersServiceImpl implements ChaptersServiceI{

    @Inject
    SubjectsRepository subjectsRepository;

    @Inject
    ChaptersRepository chaptersRepository;

    @Override
    public Chapters addChapter(ChaptersBean chaptersBean) throws BaseException {
        try {
            Subjects subject = subjectsRepository.findOne(chaptersBean.getSubjectId());
            Chapters chapter = new Chapters(chaptersBean.getPrice(), chaptersBean.getChapterName(), chaptersBean.getIndexing(), subject, chaptersBean.getStatus());
            return chaptersRepository.save(chapter);
        } catch (Exception ex) {
            ErrorConstants err = ErrorConstants.DATA_PERSISTANT_EXCEPTION;
            throw new BaseException(err.errorCode, err.errorMessage, ex.getCause());
        }
    }

    @Override
    public Chapters deactivateChapter(Long chapterId) throws BaseException {
        try {
            Chapters chapter = chaptersRepository.findOne(chapterId);
            chapter.setStatus(STATUS.INACTIVE);
            return chaptersRepository.save(chapter);
        } catch (Exception ex) {
            ErrorConstants err = ErrorConstants.DATA_PERSISTANT_EXCEPTION;
            throw new BaseException(err.errorCode, err.errorMessage, ex.getCause());
        }
    }

    @Override
    public Chapters findChapter(Long chapterId) throws BaseException {
        try {
            return chaptersRepository.findOne(chapterId);
        } catch (Exception ex) {
            ErrorConstants err = ErrorConstants.DATA_FETCH_EXCEPTION;
            throw new BaseException(err.errorCode, err.errorMessage, ex.getCause());
        }
    }

    @Override
    public List<Chapters> findAllChapters() throws BaseException {
        try {
            return chaptersRepository.findAll();
        } catch (Exception ex) {
            ErrorConstants err = ErrorConstants.DATA_FETCH_EXCEPTION;
            throw new BaseException(err.errorCode, err.errorMessage, ex.getCause());
        }
    }

    @Override
    public Chapters updateChapter(ChaptersBean chaptersBean) throws BaseException {
        try {
            Chapters chapter = chaptersRepository.findOne(chaptersBean.getChapterId());
            if(Util.notNull(chaptersBean.getChapterName()))
                chapter.setChapterName(chaptersBean.getChapterName());

            if(chaptersBean.getPrice() != null)
                chapter.setPrice(chaptersBean.getPrice());
            if(chaptersBean.getIndexing() != null)
                chapter.setIndexing(chaptersBean.getIndexing());
            if(chaptersBean.getStatus() != null)
                chapter.setStatus(chaptersBean.getStatus());

            return chaptersRepository.save(chapter);
        } catch (Exception ex) {
            ErrorConstants err = ErrorConstants.DATA_UPDATION_EXCEPTION;
            throw new BaseException(err.errorCode, err.errorMessage, ex.getCause());
        }
    }
}
