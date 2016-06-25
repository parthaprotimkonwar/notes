package models.core;

import application.enums.STATUS;
import models.Constants;
import models.core.question_answers.ModuleQuestionsAnswers;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by pkonwar on 4/9/2016.
 */
@Entity
@Table(name = "MODULES", schema = Constants.SCHEMA_NAME_CORE_MODULES)
public class Modules implements Serializable{

    public Modules() {}

    public Modules(Long moduleId, Chapters chapter) {
        this.moduleId = moduleId;
        this.chapter = chapter;
    }

    public Modules(Chapters chapter, String moduleName, Integer indexing, STATUS status) {
        this.chapter = chapter;
        this.moduleName = moduleName;
        this.indexing = indexing;
        this.status = status;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "MODULE_ID")
    private Long moduleId;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "CHAPTER_ID")
    private Chapters chapter;

    @Column(name = "MODULE_NAME", length = 30)
    private String moduleName;

    @Column(name = "INDEXING", nullable = false)
    private Integer indexing;

    @Column(name = "STATUS")
    @Enumerated(value = EnumType.ORDINAL)
    private STATUS status;

    @OneToMany(mappedBy = "moduleIdQuestionsAnswersId.module", cascade = {CascadeType.MERGE}, orphanRemoval = true)
    private Set<ModuleQuestionsAnswers> moduleQuestionAnswers;

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

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public Chapters getChapter() {
        return chapter;
    }

    public void setChapter(Chapters chapter) {
        this.chapter = chapter;
    }

    public Long getModuleId() {
        return moduleId;
    }

    public void setModuleId(Long moduleId) {
        this.moduleId = moduleId;
    }
}