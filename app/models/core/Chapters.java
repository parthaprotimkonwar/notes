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

    public Chapters(Float price, String chapterName, Integer indexing, Subjects subject, STATUS status) {
        this.price = (price==null ? 0l:price);
        this.chapterName = chapterName;
        this.indexing = (indexing==null ? 0:indexing);
        this.subject = subject;
        this.status = (status==null ? STATUS.ACTIVE:status);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "CHAPTER_ID")
    private Long chapterId;

    @Column(name = "PRICE", nullable = false)
    private Float price;

    @Column(name = "CHAPTER_NAME", nullable = false, length = 30)
    private String chapterName;

    @Column(name = "INDEXING", nullable = false)
    private Integer indexing;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "SUBJECT_ID")
    private Subjects subject;

    @Column(name = "STATUS")
    @Enumerated(value = EnumType.ORDINAL)
    private STATUS status;

    @OneToMany(mappedBy = "chapter", cascade = {CascadeType.MERGE}, orphanRemoval = true)
    private Set<Modules> modules;

    @OneToMany(mappedBy = "userIdChapterId.chapterId", cascade = {CascadeType.MERGE}, orphanRemoval = true)
    private Set<UserChapters> userChapters;

    @Override
    public boolean equals(Object thatChapter) {
        if(thatChapter == null || thatChapter.getClass() != getClass())
            return false;

        Chapters chapters = (Chapters)thatChapter;
        return chapters.chapterId.equals(chapterId);
    }

    @Override
    public int hashCode() {
        return chapterId == null ? 17 : chapterId.hashCode();
    }

    public ChaptersBean toChapterBean() {
        return new ChaptersBean(chapterId, price, chapterName, indexing, subject.getSubjectId(), status);
    }

    public STATUS getStatus() {
        return status;
    }

    public void setStatus(STATUS status) {
        this.status = status;
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

    public Subjects getSubject() {
        return subject;
    }

    public void setSubject(Subjects subject) {
        this.subject = subject;
    }
}
