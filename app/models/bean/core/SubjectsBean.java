package models.bean.core;

import application.enums.STATUS;

import java.io.Serializable;

/**
 * Created by pkonwar on 4/9/2016.
 */
public class SubjectsBean implements Serializable {

    public SubjectsBean() {}

    public SubjectsBean(Long subjectId) {
        this.subjectId = subjectId;
    }

    public SubjectsBean(String subjectName, Float price, String imageUrl, STATUS status) {
        this.subjectName = subjectName;
        this.price = price;
        this.imageUrl = imageUrl;
        this.status = status;
    }

    private Long subjectId;
    private String subjectName;
    private Float price;
    private String imageUrl;
    private STATUS status;

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

    public STATUS getStatus() {
        return status;
    }

    public void setStatus(STATUS status) {
        this.status = status;
    }
}