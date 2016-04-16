package models.bean.core;

import models.core.Subjects;

import java.io.Serializable;

/**
 * Created by pkonwar on 4/9/2016.
 */
public class ChaptersBean implements Serializable {


    public ChaptersBean(Long chapterId, Float price, String chapterName, Integer indexing, Subjects subjectId) {
        this.chapterId = chapterId;
        this.price = price;
        this.chapterName = chapterName;
        this.indexing = indexing;
        this.subjectId = subjectId;
    }

    private Long chapterId;
    private Float price;
    private String chapterName;
    private Integer indexing;
    private Subjects subjectId;


    public Long getChapterId() {
        return chapterId;
    }

    public void setChapterId(Long chapterId) {
        this.chapterId = chapterId;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public Integer getIndexing() {
        return indexing;
    }

    public void setIndexing(Integer indexing) {
        this.indexing = indexing;
    }

    public Subjects getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Subjects subjectId) {
        this.subjectId = subjectId;
    }
}
