package models.bean.core;

import application.enums.STATUS;

import java.io.Serializable;

/**
 * Created by pkonwar on 4/9/2016.
 */
public class ModulesBean implements Serializable {

    public ModulesBean(Long moduleId) {
        this.moduleId = moduleId;
    }

    public ModulesBean(Long moduleId, String moduleName, Long chapterId, Integer indexing, STATUS status) {
        this.moduleId = moduleId;
        this.moduleName = moduleName;
        this.chapterId = chapterId;
        this.indexing = indexing;
        this.status = status;
    }

    private Long moduleId;
    private Long chapterId;
    private String moduleName;
    private Integer indexing;
    private STATUS status;

    public Long getModuleId() {
        return moduleId;
    }

    public void setModuleId(Long moduleId) {
        this.moduleId = moduleId;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public Integer getIndexing() {
        return indexing;
    }

    public void setIndexing(Integer indexing) {
        this.indexing = indexing;
    }

    public STATUS getStatus() {
        return status;
    }

    public void setStatus(STATUS status) {
        this.status = status;
    }

    public Long getChapterId() {
        return chapterId;
    }

    public void setChapterId(Long chapterId) {
        this.chapterId = chapterId;
    }
}
