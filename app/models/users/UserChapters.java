package models.users;

import models.Constants;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by pkonwar on 4/9/2016.
 */
@Entity
@Table(name = "USER_CHAPTERS", schema = Constants.SCHEMA_NAME_USER)
public class UserChapters implements Serializable{

    public UserChapters() {}

    public UserChapters(UserIdChapterId userIdChapterId, Date expirationDate) {
        this.userIdChapterId = userIdChapterId;
        this.expirationDate = expirationDate;
    }

    @EmbeddedId
    private UserIdChapterId userIdChapterId;

    @Column(name = "EXPIRATION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expirationDate;

    public UserIdChapterId getUserIdChapterId() {
        return userIdChapterId;
    }

    public void setUserIdChapterId(UserIdChapterId userIdChapterId) {
        this.userIdChapterId = userIdChapterId;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }
}