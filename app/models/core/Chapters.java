package models.core;

import application.enums.STATUS;
import models.Constants;
import models.bean.core.ChaptersBean;
import models.users.UserChapters;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by pkonwar on 4/9/2016.
 */
@Entity
@Table(name = "CHAPTERS", schema = Constants.SCHEMA_NAME_CORE_MODULES)
public class Chapters implements Serializable {

    public Chapters() {}

    public Chapters(Float price, String chapterName, Integer indexing, Subjects subjectId, STATUS status) {
        this.price = price;
        this.chapterName = chapterName;
        this.indexing = indexing;
        this.subjectId = subjectId;
        this.status = status;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CHAPTER_ID")
    private Long chapterId;

    @Column(name = "PRICE", nullable = false)
    private Float price;

    @Column(name = "CHAPTER_NAME", nullable = false, length = 30)
    private String chapterName;

    @Column(name = "INDEXING", unique = true, nullable = false)
    private Integer indexing;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "SUBJECT_ID")
    private Subjects subjectId;

    @Column(name = "STATUS")
    @Enumerated(value = EnumType.ORDINAL)
    private STATUS status;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "moduleId")
    private Set<Modules> modules;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userIdChapterId.chapterId")
    private Set<UserChapters> userChapters;

    public ChaptersBean toChapterBean() {
        return new ChaptersBean(chapterId, price, chapterName, indexing, subjectId.getSubjectId(), status);
    }

    public STATUS getStatus() {
        return status;
    }

    public void setStatus(STATUS status) {
        this.status = status;
    }

    public Subjects getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Subjects subjectId) {
        this.subjectId = subjectId;
    }

    public Integer getIndexing() {
        return indexing;
    }

    public void setIndexing(Integer indexing) {
        this.indexing = indexing;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Long getChapterId() {
        return chapterId;
    }

    public void setChapterId(Long chapterId) {
        this.chapterId = chapterId;
    }
}
