package services.service.users;

import application.exceptions.BaseException;
import models.bean.users.UserChaptersBean;
import models.core.Chapters;
import models.users.User;
import models.users.UserChapters;

import java.util.Date;

/**
 * Created by pkonwar on 4/16/2016.
 */

public interface UserChapterServiceI {

    /**
     * Add a new Chapter to a user account
     * @param userChaptersBean
     * @return
     * @throws BaseException
     */
    UserChapters addChapters(UserChaptersBean userChaptersBean) throws BaseException;

    /**
     *
     * @param user
     * @param chapterId
     * @param expirationDate
     * @return
     * @throws BaseException
     */
    UserChapters addChapters(User user, Long chapterId, Date expirationDate) throws BaseException;

    /**
     * Remove a new Chapter
     * @param userChaptersBean
     */
    void removeChapter(UserChaptersBean userChaptersBean) throws BaseException;

    /**
     * Remove a Chapter
     * @param user
     * @param chapterId
     * @throws BaseException
     */
    void removeChapters(User user, Long chapterId) throws BaseException;


    /**
     * Expiration Date updation for the user
     * @param user
     * @param chapters
     * @param newExpirationDate : updated expiration date
     * @throws BaseException
     */
    void updateExpirationDate(User user, Chapters chapters, Date newExpirationDate) throws BaseException;
}