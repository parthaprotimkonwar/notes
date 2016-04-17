package services.service.core;

import application.exceptions.BaseException;
import models.bean.core.AuthorsBean;
import models.core.Authors;

import java.util.List;

/**
 * Created by pkonwar on 4/17/2016.
 */
public interface AuthorsServiceI {

    /**
     * Add an AUTHOR
     * @param authorsBean
     * @return
     * @throws BaseException
     */
    Authors addAuthor(AuthorsBean authorsBean) throws BaseException;

    /**
     * Modify an AUTHOR
     * @param authorsBean
     * @return
     * @throws BaseException
     */
    Authors modifyAuthor(AuthorsBean authorsBean) throws BaseException;

    /**
     * Find an AUTHOR
     * @param authorId
     * @return
     * @throws BaseException
     */
    Authors findAuthor(Long authorId) throws BaseException;

    /**
     * Find all AUTHOR
     * @return
     * @throws BaseException
     */
    List<Authors> findAllAuthors() throws BaseException;
}
