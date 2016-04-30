package services.service.impl.core;

import application.exceptions.BaseException;
import application.exceptions.ErrorConstants;
import application.utilities.Util;
import models.bean.core.AuthorsBean;
import models.core.Authors;
import repository.core.AuthorsRepository;
import services.service.core.AuthorsServiceI;

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
public class AuthorsServiceImpl implements AuthorsServiceI {

    @Inject
    AuthorsRepository authorsRepository;

    @Override
    public Authors addAuthor(AuthorsBean authorsBean) throws BaseException {
        try {
            Authors authors = new Authors(authorsBean.getAuthorName(), authorsBean.getAuthorDescription());
            return authorsRepository.save(authors);
        } catch (Exception ex) {
            ErrorConstants err = ErrorConstants.DATA_PERSISTANT_EXCEPTION;
            throw new BaseException(err.errorCode, err.errorMessage, ex.getCause());
        }
    }

    @Override
    public Authors modifyAuthor(AuthorsBean authorsBean) throws BaseException {
        try {
            Authors author = authorsRepository.findOne(authorsBean.getAuthorId());
            if (Util.notNull(authorsBean.getAuthorName())) {
                author.setAuthorName(authorsBean.getAuthorName());
            }
            if (Util.notNull(authorsBean.getAuthorDescription())) {
                author.setAuthorDescription(authorsBean.getAuthorDescription());
            }
            return authorsRepository.save(author);
        } catch (Exception ex) {
            ErrorConstants err = ErrorConstants.DATA_PERSISTANT_EXCEPTION;
            throw new BaseException(err.errorCode, err.errorMessage, ex.getCause());
        }

    }

    @Override
    public Authors findAuthor(Long authorId) throws BaseException {
        try {
            return authorsRepository.findOne(authorId);
        } catch (Exception ex) {
            ErrorConstants err = ErrorConstants.DATA_FETCH_EXCEPTION;
            throw new BaseException(err.errorCode, err.errorMessage, ex.getCause());
        }
    }

    @Override
    public List<Authors> findAllAuthors() throws BaseException {
        try {
            return authorsRepository.findAll();
        } catch (Exception ex) {
            ErrorConstants err = ErrorConstants.DATA_FETCH_EXCEPTION;
            throw new BaseException(err.errorCode, err.errorMessage, ex.getCause());
        }
    }

    @Override
    public List<AuthorsBean> convertToAuthorsBean(List<Authors> authorsList) throws BaseException {
        List<AuthorsBean> authorsBeansList = new ArrayList<>();
        for(Authors author : authorsList) {
            authorsBeansList.add(new AuthorsBean(author.getAuthorId(), author.getAuthorName(), author.getAuthorDescription()));
        }
        return authorsBeansList;
    }
}
