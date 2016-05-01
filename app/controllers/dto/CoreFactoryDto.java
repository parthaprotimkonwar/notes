package controllers.dto;

import models.bean.core.*;

import java.io.Serializable;
import java.util.List;

/**
 * Created by pkonwar on 4/30/2016.
 */
public class CoreFactoryDto implements Serializable{

    private List<SubjectsBean> subjects;

    private List<ChaptersBean> chapters;

    private List<ModulesBean> modules;

    private List<AuthorsBean> authors;

    private List<SubjectAuthorBean> subjectAuthor;

    public List<SubjectsBean> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<SubjectsBean> subjects) {
        this.subjects = subjects;
    }

    public List<ChaptersBean> getChapters() {
        return chapters;
    }

    public void setChapters(List<ChaptersBean> chapters) {
        this.chapters = chapters;
    }

    public List<ModulesBean> getModules() {
        return modules;
    }

    public void setModules(List<ModulesBean> modules) {
        this.modules = modules;
    }

    public List<AuthorsBean> getAuthors() {
        return authors;
    }

    public void setAuthors(List<AuthorsBean> authors) {
        this.authors = authors;
    }

    public List<SubjectAuthorBean> getSubjectAuthor() {
        return subjectAuthor;
    }

    public void setSubjectAuthor(List<SubjectAuthorBean> subjectAuthor) {
        this.subjectAuthor = subjectAuthor;
    }
}
