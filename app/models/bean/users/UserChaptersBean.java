package models.bean.users;

import models.Constants;
import models.users.UserIdChapterId;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by pkonwar on 4/9/2016.
 */
public class UserChaptersBean implements Serializable{

    public UserChaptersBean() {}

    public UserChaptersBean(UserIdChapterIdBean userIdChapterIdBean, Date expirationDate) {
        this.userIdChapterIdBean = userIdChapterIdBean;
        this.expirationDate = expirationDate;
    }

    private UserIdChapterIdBean userIdChapterIdBean;

    private Date expirationDate;

    public UserIdChapterIdBean getUserIdChapterIdBean() {
        return userIdChapterIdBean;
    }

    public void setUserIdChapterIdBean(UserIdChapterIdBean userIdChapterIdBean) {
        this.userIdChapterIdBean = userIdChapterIdBean;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }
}