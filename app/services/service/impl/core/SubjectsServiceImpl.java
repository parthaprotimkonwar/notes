package services.service.impl.core;

import application.enums.STATUS;
import application.exceptions.BaseException;
import application.exceptions.ErrorConstants;
import application.utilities.Util;
import models.bean.core.SubjectsBean;
import models.core.Subjects;
import org.springframework.transaction.annotation.Transactional;
import repository.core.SubjectsRepository;
import services.service.core.SubjectsServiceI;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pkonwar on 4/17/2016.
 */
@Named
@Singleton
@Transactional
public class SubjectsServiceImpl implements SubjectsServiceI{

    @Inject
    SubjectsRepository subjectsRepository;

    @Override
    public Subjects addSubject(SubjectsBean subjectsBean) throws BaseException {
        try {
            Subjects subjects = new Subjects(subjectsBean.getSubjectName(), subjectsBean.getPrice(), subjectsBean.getImageUrl(), subjectsBean.getStatus());
            return subjectsRepository.save(subjects);
        } catch (Exception ex) {
            ErrorConstants err = ErrorConstants.DATA_PERSISTANT_EXCEPTION;
            throw new BaseException(err.errorCode, err.errorMessage, ex.getCause());
        }
    }

    @Override
    public Subjects deactivateSubject(Long subjectId) throws BaseException{
        try {
            Subjects subject = subjectsRepository.findOne(subjectId);
            subject.setStatus(STATUS.INACTIVE);
            return subjectsRepository.save(subject);
        } catch (Exception ex) {
            ErrorConstants err = ErrorConstants.DATA_FETCH_EXCEPTION;
            throw new BaseException(err.errorCode, err.errorMessage, ex.getCause());
        }
    }

    @Override
    public Subjects findSubject(Long subjectId) throws BaseException {
        try {
            return subjectsRepository.findOne(subjectId);
        } catch (Exception ex) {
            ErrorConstants err = ErrorConstants.DATA_FETCH_EXCEPTION;
            throw new BaseException(err.errorCode, err.errorMessage, ex.getCause());
        }
    }

    @Override
    public List<Subjects> findAllSubjects() throws BaseException {
        try {
            return subjectsRepository.findAll();
        } catch (Exception ex) {
            ErrorConstants err = ErrorConstants.DATA_FETCH_EXCEPTION;
            throw new BaseException(err.errorCode, err.errorMessage, ex.getCause());
        }
    }

    @Override
    public Subjects updateSubject(SubjectsBean subjectsBean) throws BaseException {
        try {
            Subjects subject = subjectsRepository.findOne(subjectsBean.getSubjectId());
            if (Util.notNull(subjectsBean.getSubjectName())) {
                subject.setSubjectName(subjectsBean.getSubjectName());
            }
            if (subjectsBean.getPrice() != null) {
                subject.setPrice(subjectsBean.getPrice());
            }
            if (Util.notNull(subjectsBean.getImageUrl())) {
                subject.setImageUrl(subjectsBean.getImageUrl());
            }
            if (subjectsBean.getStatus() != null) {
                subject.setStatus(subjectsBean.getStatus());
            }
            return subjectsRepository.save(subject);
        } catch (Exception ex) {
            ErrorConstants err = ErrorConstants.DATA_UPDATION_EXCEPTION;
            throw new BaseException(err.errorCode, err.errorMessage, ex.getCause());
        }
    }

    @Override
    public List<SubjectsBean> convertToSubjectBean(List<Subjects> subjects) throws BaseException {

        List<SubjectsBean> subjectsBeans = new ArrayList<>();
        for(Subjects subject : subjects) {
            subjectsBeans.add(subject.toSubjectBean());
        }
        return subjectsBeans;
    }
}