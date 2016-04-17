package models.bean.core.question_answers;

import models.Constants;
import models.core.question_answers.ModuleIdQuestionsAnswersId;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by pkonwar on 4/17/2016.
 */
public class ModuleQuestionsAnswersBean implements Serializable {

    public ModuleQuestionsAnswersBean(Long questionsAnswerId, Long moduleId, Integer indexing) {
        this.questionsAnswerId = questionsAnswerId;
        this.moduleId = moduleId;
        this.indexing = indexing;
    }

    private Long questionsAnswerId;

    private Long moduleId;

    private Integer indexing;

    public Long getQuestionsAnswerId() {
        return questionsAnswerId;
    }

    public void setQuestionsAnswerId(Long questionsAnswerId) {
        this.questionsAnswerId = questionsAnswerId;
    }

    public Long getModuleId() {
        return moduleId;
    }

    public void setModuleId(Long moduleId) {
        this.moduleId = moduleId;
    }

    public Integer getIndexing() {
        return indexing;
    }

    public void setIndexing(Integer indexing) {
        this.indexing = indexing;
    }
}
