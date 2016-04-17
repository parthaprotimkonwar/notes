package services.service.core;

import application.exceptions.BaseException;
import models.core.Authors;
import models.core.SubjectAuthor;

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

}
