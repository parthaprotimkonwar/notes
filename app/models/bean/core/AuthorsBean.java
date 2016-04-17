package models.bean.core;

import models.Constants;
import models.core.SubjectAuthor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by pkonwar on 4/9/2016.
 */
public class AuthorsBean implements Serializable{

    public AuthorsBean() {}

    public AuthorsBean(Long authorId) {
        this.authorId = authorId;
    }

    public AuthorsBean(String authorName, String authorDescription) {
        this.authorName = authorName;
        this.authorDescription = authorDescription;
    }

    private Long authorId;
    private String authorName;
    private String authorDescription;

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public String getAuthorDescription() {
        return authorDescription;
    }

    public void setAuthorDescription(String authorDescription) {
        this.authorDescription = authorDescription;
    }
}
