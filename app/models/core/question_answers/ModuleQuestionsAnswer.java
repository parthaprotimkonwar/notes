package models.core.question_answers;

import application.enums.QA_TYPE;
import models.Constants;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by pkonwar on 4/9/2016.
 */
@Entity
@Table(name = "MODULE_QUESTIONS", schema = Constants.SCHEMA_NAME_CORE_MODULES_QA)
public class ModuleQuestionsAnswer implements Serializable{

    public ModuleQuestionsAnswer(ModuleIdQuestionIdAnswerId moduleIdQuestionIdAnswerId, QA_TYPE type, Integer indexing) {
        this.moduleIdQuestionIdAnswerId = moduleIdQuestionIdAnswerId;
        this.type = type;
        this.indexing = indexing;
    }

    @EmbeddedId
    private ModuleIdQuestionIdAnswerId moduleIdQuestionIdAnswerId;

    @Column(name = "TYPE")
    @Enumerated(value = EnumType.ORDINAL)
    private QA_TYPE type;

    @Column(name = "INDEXING", unique = true, nullable = false)
    private Integer indexing;

}
