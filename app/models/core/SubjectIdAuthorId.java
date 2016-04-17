package models.core;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Created by pkonwar on 4/9/2016.
 */
@Embeddable
public class SubjectIdAuthorId implements Serializable{

    public SubjectIdAuthorId() {}

    public SubjectIdAuthorId(Subjects subjects, Authors authors) {
        this.subjectId = subjects;
        this.authorId = authors;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "SUBJECT_ID")
    private Subjects subjectId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "AUTHOR_ID")
    private Authors authorId;

    public Subjects getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Subjects subjectId) {
        this.subjectId = subjectId;
    }

    public Authors getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Authors authorId) {
        this.authorId = authorId;
    }
}
