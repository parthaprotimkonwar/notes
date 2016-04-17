package models.core;

import models.Constants;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by pkonwar on 4/9/2016.
 */
@Entity
@Table(name = "SUBJECT_AUTHOR", schema = Constants.SCHEMA_NAME_CORE_MODULES)
public class SubjectAuthor implements Serializable{
    public SubjectAuthor(){}

    public SubjectAuthor(SubjectIdAuthorId subjectIdAuthorId){
        this.subjectIdAuthorId = subjectIdAuthorId;
    }

    @EmbeddedId
    private SubjectIdAuthorId subjectIdAuthorId;

    public SubjectIdAuthorId getSubjectIdAuthorId() {
        return subjectIdAuthorId;
    }

    public void setSubjectIdAuthorId(SubjectIdAuthorId subjectIdAuthorId) {
        this.subjectIdAuthorId = subjectIdAuthorId;
    }
}
