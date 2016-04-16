package models.core;

import models.Constants;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by pkonwar on 4/9/2016.
 */
@Entity
@Table(name = "SUBJECTS", schema = Constants.SCHEMA_NAME_CORE_MODULES)
public class Subjects implements Serializable {

    public Subjects() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SUBJECT_ID")
    private Long subjectId;

    @Column(name = "SUBJECT_NAME", length = 50, nullable = false)
    private String subjectName;

    @Column(name = "PRICE", nullable = false)
    private Float price;

    @Column(name = "IMAGE_URL", nullable = false)
    private String imageUrl;

    @OneToMany(mappedBy = "chapterId")
    private Set<Chapters> chapters;

    @OneToMany(mappedBy = "subjectIdAuthorId.subjectId")
    private Set<SubjectAuthor> subjectAuthor;

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Set<Chapters> getChapters() {
        return chapters;
    }

    public void setChapters(Set<Chapters> chapters) {
        this.chapters = chapters;
    }

    public Set<SubjectAuthor> getSubjectAuthor() {
        return subjectAuthor;
    }

    public void setSubjectAuthor(Set<SubjectAuthor> subjectAuthor) {
        this.subjectAuthor = subjectAuthor;
    }
}
