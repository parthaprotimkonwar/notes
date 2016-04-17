package services.service.core;

import application.exceptions.BaseException;
import models.bean.core.SubjectsBean;
import models.core.Subjects;

/**
 * Created by pkonwar on 4/17/2016.
 */
public interface SubjectsServiceI {

    /**
     * add a Subject/Course to the catalog.
     * @param subjectsBean
     * @return
     */
    Subjects addSubject(SubjectsBean subjectsBean) throws BaseException;


    /**
     * make a Subject in-active.
     * @param subjectId
     * @return
     */
    Subjects deactivateSubject(Long subjectId) throws BaseException;

    /**
     * Find a subject
     * @param subjectId
     * @return
     * @throws BaseException
     */
    Subjects findSubject(Long subjectId) throws BaseException;

    /**
     * Update a subject
     * @param subjectsBean
     * @return
     * @throws BaseException
     */
    Subjects updateSubject(SubjectsBean subjectsBean) throws BaseException;

}
