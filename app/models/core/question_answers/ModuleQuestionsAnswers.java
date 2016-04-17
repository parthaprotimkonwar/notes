package models.core.question_answers;

import models.Constants;
import models.core.Modules;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by pkonwar on 4/17/2016.
 */
@Entity
@Table(name = "MODULE_QUESTIONS_ANSWERS", schema = Constants.SCHEMA_NAME_CORE_MODULES_QA)
public class ModuleQuestionsAnswers implements Serializable{

    public ModuleQuestionsAnswers(ModuleIdQuestionsAnswersId moduleIdQuestionsAnswersId, Integer indexing){
        this.moduleIdQuestionsAnswersId = moduleIdQuestionsAnswersId;
        this.indexing = indexing;
    }
    @EmbeddedId
    private ModuleIdQuestionsAnswersId moduleIdQuestionsAnswersId;

    @Column(name = "INDEXING", unique = true, nullable = false)
    private Integer indexing;

    public ModuleIdQuestionsAnswersId getModuleIdQuestionsAnswersId() {
        return moduleIdQuestionsAnswersId;
    }

    public void setModuleIdQuestionsAnswersId(ModuleIdQuestionsAnswersId moduleIdQuestionsAnswersId) {
        this.moduleIdQuestionsAnswersId = moduleIdQuestionsAnswersId;
    }

    public Integer getIndexing() {
        return indexing;
    }

    public void setIndexing(Integer indexing) {
        this.indexing = indexing;
    }
}
