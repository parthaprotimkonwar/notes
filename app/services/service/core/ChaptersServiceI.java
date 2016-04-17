package services.service.core;

import application.exceptions.BaseException;
import models.bean.core.ChaptersBean;
import models.core.Chapters;

import java.util.List;

/**
 * Created by pkonwar on 4/17/2016.
 */
public interface ChaptersServiceI {
    /**
     * Add a Chapter
     * @param chaptersBean
     * @return
     * @throws BaseException
     */
    Chapters addChapter(ChaptersBean chaptersBean) throws BaseException;

    /**
     * Deactivate a chapter
     * @param chapterId
     * @return
     * @throws BaseException
     */
    Chapters deactivateChapter(Long chapterId) throws BaseException;

    /**
     * Find a chapter
     * @param chapterId
     * @return
     * @throws BaseException
     */
    Chapters findChapter(Long chapterId) throws BaseException;

    /**
     * Find all chapters
     * @return
     * @throws BaseException
     */
    List<Chapters> findAllChapters() throws BaseException;

    /**
     * Update a chapter
     * @param chaptersBean
     * @return
     * @throws BaseException
     */
    Chapters updateChapter(ChaptersBean chaptersBean) throws BaseException;
}
