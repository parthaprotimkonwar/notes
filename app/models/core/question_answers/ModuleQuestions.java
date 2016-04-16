package models.core.question_answers;

import models.Constants;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by pkonwar on 4/9/2016.
 */
@Entity
@Table(name = "MODULE_QUESTIONS", schema = Constants.SCHEMA_NAME_CORE_MODULES_QA)
public class ModuleQuestions implements Serializable{

    @EmbeddedId
    private ModuleIdQuestionId moduleIdQuestionId;

    @ManyToOne
    @JoinColumn(name = "ANSWER_ID")
    private Answers answerId;

    @Column(name = "TYPE")
    @Enumerated(value = EnumType.ORDINAL)
    private QA_TYPE type;

    @Column(name = "INDEXING", unique = true, nullable = false)
    private Integer indexing;

}
