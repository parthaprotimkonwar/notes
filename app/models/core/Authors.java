package models.core;

import utilities.Constants;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by pkonwar on 4/9/2016.
 */
@Entity
@Table(name = "AUTHORS", schema = Constants.SCHEMA_NAME_CORE_MODULES)
public class Authors implements Serializable{

    public Authors() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AUTHOR_ID")
    private Long authorId;

    @Column(name = "AUTHOR_NAME", length = 25, nullable = false)
    private String authorName;

    @Column(name = "AUTHOR_DESCRIPTION")
    @Lob
    private String authorDescription;

    @OneToMany(mappedBy = "subjectIdAuthorId.authorId")
    private Set<SubjectAuthor> subjectAuthor;

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorDescription() {
        return authorDescription;
    }

    public void setAuthorDescription(String authorDescription) {
        this.authorDescription = authorDescription;
    }

    public Set<SubjectAuthor> getSubjectAuthor() {
        return subjectAuthor;
    }

    public void setSubjectAuthor(Set<SubjectAuthor> subjectAuthor) {
        this.subjectAuthor = subjectAuthor;
    }
}
