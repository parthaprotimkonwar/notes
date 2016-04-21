package models.core;

import application.enums.STATUS;
import models.Constants;
import models.bean.core.SubjectsBean;

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

    public Subjects(String subjectName, Float price, String imageUrl, STATUS status) {
        this.subjectName = subjectName;
        this.price = price;
        this.imageUrl = imageUrl;
        this.status = status;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "SUBJECT_ID")
    private Long subjectId;

    @Column(name = "SUBJECT_NAME", length = 50, nullable = false)
    private String subjectName;

    @Column(name = "PRICE", nullable = false)
    private Float price;

    @Column(name = "IMAGE_URL", nullable = false)
    private String imageUrl;

    @Column(name = "STATUS")
    @Enumerated(value = EnumType.ORDINAL)
    private STATUS status;

    @OneToMany(mappedBy = "subject", cascade = {CascadeType.MERGE}, orphanRemoval = true)
    private Set<Chapters> chapters;

    @OneToMany(mappedBy = "subjectIdAuthorId.subjectId", cascade = {CascadeType.MERGE}, orphanRemoval = true)
    private Set<SubjectAuthor> subjectAuthor;

    @Override
    public boolean equals(Object thatSubject) {
        if(thatSubject == null || thatSubject.getClass() != getClass())
            return false;

        Subjects subjects = (Subjects)thatSubject;
        return subjects.subjectId.equals(subjectId);
    }

    @Override
    public int hashCode() {
        return subjectId != null ? subjectId.hashCode() : 17;
    }

    public SubjectsBean toSubjectBean() {
        return new SubjectsBean(subjectId, subjectName, price, imageUrl, status);
    }

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

    public STATUS getStatus() {
        return status;
    }

    public void setStatus(STATUS status) {
        this.status = status;
    }
}
