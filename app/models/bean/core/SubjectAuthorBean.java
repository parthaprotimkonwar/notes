package models.bean.core;

import java.io.Serializable;

/**
 * Created by pkonwar on 4/9/2016.
 */
public class SubjectAuthorBean implements Serializable {

    public SubjectAuthorBean(){}

    public SubjectAuthorBean(SubjectIdAuthorIdBean subjectIdAuthorIdBean){
        this.subjectIdAuthorIdBean = subjectIdAuthorIdBean;
    }

    private SubjectIdAuthorIdBean subjectIdAuthorIdBean;

    public SubjectIdAuthorIdBean getSubjectIdAuthorIdBean() {
        return subjectIdAuthorIdBean;
    }

    public void setSubjectIdAuthorIdBean(SubjectIdAuthorIdBean subjectIdAuthorIdBean) {
        this.subjectIdAuthorIdBean = subjectIdAuthorIdBean;
    }
}
