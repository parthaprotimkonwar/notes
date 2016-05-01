package services.service.impl.core;

import application.exceptions.BaseException;
import application.exceptions.ErrorConstants;
import models.bean.core.SubjectAuthorBean;
import models.core.Authors;
import models.core.SubjectAuthor;
import models.core.SubjectIdAuthorId;
import models.core.Subjects;
import repository.core.AuthorsRepository;
import repository.core.SubjectAuthorRepository;
import repository.core.SubjectsRepository;
import services.service.core.SubjectAuthorServiceI;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pkonwar on 4/17/2016.
 */
public class SubjectAuthorServiceImpl implements SubjectAuthorServiceI{

    @Inject
    SubjectAuthorRepository subjectAuthorRepository;

    @Inject
    SubjectsRepository subjectsRepository;

    @Inject
    AuthorsRepository authorsRepository;

    @Override
    public SubjectAuthor addAuthorToSubject(Long subjectId, Long authorId) throws BaseException {
        try {
            Subjects subjects = subjectsRepository.findOne(subjectId);
            Authors authors = authorsRepository.findOne(authorId);

            SubjectIdAuthorId subjectIdAuthorId = new SubjectIdAuthorId(subjects, authors);
            SubjectAuthor subjectAuthor = new SubjectAuthor(subjectIdAuthorId);

            return subjectAuthorRepository.save(subjectAuthor);
        } catch (Exception ex) {
            ErrorConstants err = ErrorConstants.DATA_PERSISTANT_EXCEPTION;
            throw new BaseException(err.errorCode, err.errorMessage, ex.getCause());
        }
    }

    @Override
    public void removeAuthorFromSubject(Long subjectId, Long authorId) throws BaseException {
        try {
            Subjects subjects = subjectsRepository.findOne(subjectId);
            Authors authors = authorsRepository.findOne(authorId);

            SubjectIdAuthorId subjectIdAuthorId = new SubjectIdAuthorId(subjects, authors);
            subjectAuthorRepository.delete(subjectIdAuthorId);
        } catch (Exception ex) {
            ErrorConstants err = ErrorConstants.DATA_PERSISTANT_EXCEPTION;
            throw new BaseException(err.errorCode, err.errorMessage, ex.getCause());
        }
    }

    @Override
    public List<SubjectAuthor> findAllSubjectAuthor() throws BaseException {
        try {
            return subjectAuthorRepository.findAll();
        } catch (Exception ex) {
            ErrorConstants err = ErrorConstants.DATA_PERSISTANT_EXCEPTION;
            throw new BaseException(err.errorCode, err.errorMessage, ex.getCause());
        }
    }

    @Override
    public List<SubjectAuthorBean> convertToSubjectAuthorBean(List<SubjectAuthor> subjectAuthorList) throws BaseException {
        List<SubjectAuthorBean> subjectAuthorBeanList = new ArrayList<>();
        for(SubjectAuthor subjectAuthor : subjectAuthorList) {
            SubjectIdAuthorId subjectIdAuthorId = subjectAuthor.getSubjectIdAuthorId();
            subjectAuthorBeanList.add(new SubjectAuthorBean(subjectIdAuthorId.getSubjectId().getSubjectId(), subjectIdAuthorId.getAuthorId().getAuthorId()));
        }
        return subjectAuthorBeanList;
    }
}
