package models.users;

import models.core.Chapters;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Created by pkonwar on 4/9/2016.
 */
@Embeddable
public class UserIdChapterId implements Serializable{

    public UserIdChapterId() {}
    public UserIdChapterId(User user, Chapters chapter) {
        this.userId = user;
        this.chapterId = chapter;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID")
    private User userId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CHAPTER_ID")
    private Chapters chapterId;

}
