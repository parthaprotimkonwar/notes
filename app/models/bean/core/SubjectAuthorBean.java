package models.bean.core;

import java.io.Serializable;

/**
 * Created by pkonwar on 4/9/2016.
 */
public class SubjectAuthorBean implements Serializable {

    public SubjectAuthorBean(){}

    public SubjectAuthorBean(Long subjectId, Long authorId){
        this.subjectId = subjectId;
        this.authorId = authorId;
    }

    private Long subjectId;
    private Long authorId;

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }
}
