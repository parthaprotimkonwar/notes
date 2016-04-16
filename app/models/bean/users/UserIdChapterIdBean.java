package models.bean.users;

import models.bean.core.ChaptersBean;

import java.io.Serializable;

/**
 * Created by pkonwar on 4/9/2016.
 */
public class UserIdChapterIdBean implements Serializable {

    public UserIdChapterIdBean() {
    }

    public UserIdChapterIdBean(UserBean userBean, ChaptersBean chapterBean) {
        this.userBean = userBean;
        this.chapterBean = chapterBean;
    }

    private UserBean userBean;
    private ChaptersBean chapterBean;

    public UserBean getUserBean() {
        return userBean;
    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }

    public ChaptersBean getChapterBean() {
        return chapterBean;
    }

    public void setChapterBean(ChaptersBean chapterBean) {
        this.chapterBean = chapterBean;
    }
}
