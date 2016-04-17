package models.bean.core;

import models.core.SubjectIdAuthorId;

import java.io.Serializable;

/**
 * Created by pkonwar on 4/9/2016.
 */
public class SubjectIdAuthorIdBean implements Serializable {

    public SubjectIdAuthorIdBean(){}

    public SubjectIdAuthorIdBean(SubjectsBean subjectBean, AuthorsBean authorBean){
        this.subjectBean = subjectBean;
        this.authorBean = authorBean;
    }

    private SubjectsBean subjectBean;

    private AuthorsBean authorBean;

    public SubjectsBean getSubjectBean() {
        return subjectBean;
    }

    public void setSubjectBean(SubjectsBean subjectBean) {
        this.subjectBean = subjectBean;
    }

    public AuthorsBean getAuthorBean() {
        return authorBean;
    }

    public void setAuthorBean(AuthorsBean authorBean) {
        this.authorBean = authorBean;
    }
}
