package services.service.impl.users;

import application.exceptions.BaseException;
import application.exceptions.ErrorConstants;
import models.bean.core.ChaptersBean;
import models.bean.users.UserBean;
import models.bean.users.UserChaptersBean;
import models.bean.users.UserIdChapterIdBean;
import models.core.Chapters;
import models.users.User;
import models.users.UserChapters;
import models.users.UserIdChapterId;
import org.springframework.transaction.annotation.Transactional;
import repository.core.ChaptersRepository;
import repository.users.UserChaptersRepository;
import repository.users.UserRepository;
import services.service.users.UserChapterServiceI;

import javax.inject.Named;
import javax.inject.Singleton;
import java.util.Date;

/**
 * Created by pkonwar on 4/16/2016.
 */
@Named
@Singleton
@Transactional
public class UserChapterServiceImpl implements UserChapterServiceI {

    UserRepository userRepository;
    ChaptersRepository chaptersRepository;
    UserChaptersRepository userChaptersRepository;


    @Override
    public UserChapters addChapters(UserChaptersBean userChaptersBean) throws BaseException {
        try {
            UserBean userBean = userChaptersBean.getUserIdChapterIdBean().getUserBean();
            ChaptersBean chaptersBean = userChaptersBean.getUserIdChapterIdBean().getChapterBean();
            User user = userRepository.findOne(userBean.getUserId());
            return addChapters(user, chaptersBean.getChapterId(), userChaptersBean.getExpirationDate());
        } catch (Exception ex) {
            ErrorConstants err = ErrorConstants.DATA_PERSISTANT_EXCEPTION;
            throw new BaseException(err.errorCode, err.errorMessage, ex.getCause());
        }
    }

    @Override
    public UserChapters addChapters(User user, Long chapterId, Date expirationDate) throws BaseException {

        try {
            Chapters chapters = chaptersRepository.findOne(chapterId);
            UserIdChapterId userIdChapterId = new UserIdChapterId(user, chapters);
            UserChapters userChapters = new UserChapters(userIdChapterId, expirationDate);
            return userChaptersRepository.save(userChapters);
        } catch (Exception ex) {
            ErrorConstants err = ErrorConstants.DATA_PERSISTANT_EXCEPTION;
            throw new BaseException(err.errorCode, err.errorMessage, ex.getCause());
        }
    }

    @Override
    public void removeChapter(UserChaptersBean userChaptersBean) throws BaseException{
        try {
            UserBean userBean = userChaptersBean.getUserIdChapterIdBean().getUserBean();
            ChaptersBean chaptersBean = userChaptersBean.getUserIdChapterIdBean().getChapterBean();
            User user = userRepository.findOne(userBean.getUserId());
            removeChapters(user, chaptersBean.getChapterId());
        } catch (Exception ex) {
            ErrorConstants err = ErrorConstants.DATA_PERSISTANT_EXCEPTION;
            throw new BaseException(err.errorCode, err.errorMessage, ex.getCause());
        }
    }

    @Override
    public void removeChapters(User user, Long chapterId) throws BaseException {
        try {
            Chapters chapter = chaptersRepository.findOne(chapterId);
            UserIdChapterId userIdChapterId = new UserIdChapterId(user, chapter);
            userChaptersRepository.delete(userIdChapterId);
        } catch (Exception ex) {
            ErrorConstants err = ErrorConstants.DATA_REMOVAL_EXCEPTION;
            throw new BaseException(err.errorCode, err.errorMessage, ex.getCause());
        }
    }

    @Override
    public void updateExpirationDate(User user, Chapters chapters, Date newExpirationDate) throws BaseException {
        try {
            UserIdChapterId userIdChapterId = new UserIdChapterId(user, chapters);
            UserChapters userChapters = userChaptersRepository.findOne(userIdChapterId);
            userChapters.setExpirationDate(newExpirationDate);
            userChaptersRepository.save(userChapters);
        } catch (Exception ex) {
            ErrorConstants err = ErrorConstants.DATA_PERSISTANT_EXCEPTION;
            throw new BaseException(err.errorCode, err.errorMessage, ex.getCause());
        }

    }

}