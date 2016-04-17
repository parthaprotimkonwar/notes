package models.core;

import application.enums.STATUS;
import models.Constants;
import models.core.question_answers.ModuleQuestions;

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

    public Modules(Chapters chapterId, String moduleName, Integer indexing, STATUS status) {
        this.chapterId = chapterId;
        this.moduleName = moduleName;
        this.indexing = indexing;
        this.status = status;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MODULE_ID")
    private Long moduleId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CHAPTER_ID")
    private Chapters chapterId;

    @Column(name = "MODULE_NAME", length = 30)
    private String moduleName;

    @Column(name = "INDEXING", nullable = false, unique = true)
    private Integer indexing;

    @Column(name = "STATUS")
    @Enumerated(value = EnumType.ORDINAL)
    private STATUS status;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "moduleIdQuestionId.moduleId")
    private Set<ModuleQuestions> moduleQuestions;

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

    public Chapters getChapterId() {
        return chapterId;
    }

    public void setChapterId(Chapters chapterId) {
        this.chapterId = chapterId;
    }

    public Long getModuleId() {
        return moduleId;
    }

    public void setModuleId(Long moduleId) {
        this.moduleId = moduleId;
    }
}