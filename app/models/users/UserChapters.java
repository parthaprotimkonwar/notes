package models.users;

import utilities.Constants;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by pkonwar on 4/9/2016.
 */
@Entity
@Table(name = "USER_CHAPTERS", schema = Constants.SCHEMA_NAME_USER)
public class UserChapters implements Serializable{

    @EmbeddedId
    private UserIdChapterId userIdChapterId;

    @Column(name = "EXPIRATION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expirationDate;
}