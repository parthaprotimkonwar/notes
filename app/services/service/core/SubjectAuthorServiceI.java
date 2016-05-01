package services.service.core;

import application.exceptions.BaseException;
import com.fasterxml.jackson.databind.deser.Deserializers;
import models.bean.core.SubjectAuthorBean;
import models.core.Authors;
import models.core.SubjectAuthor;

import java.util.List;

/**
 * Created by pkonwar on 4/17/2016.
 */
public interface SubjectAuthorServiceI {

    /**
     * Associate an AUTHOR with a SUBJECT
     * @param subjectId
     * @param authorId
     * @return
     * @throws BaseException
     */
    SubjectAuthor addAuthorToSubject(Long subjectId, Long authorId) throws BaseException;

    /**
     * Remove an AUTHOR from a SUBJECT
     * @param subjectId
     * @param authorId
     * @throws BaseException
     */
    void removeAuthorFromSubject(Long subjectId, Long authorId) throws BaseException;


    /**
     * All SubjectsAuthors
     * @return
     * @throws BaseException
     */
    List<SubjectAuthor> findAllSubjectAuthor() throws BaseException;


    /**
     * Convert to SubjectAuthorBean
     * @return
     * @throws BaseException
     */
    List<SubjectAuthorBean> convertToSubjectAuthorBean(List<SubjectAuthor> subjectAuthorList) throws BaseException;

}
