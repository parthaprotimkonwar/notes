package models.core.question_answers;

import models.core.Modules;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Created by pkonwar on 4/9/2016.
 */
@Embeddable
public class ModuleIdQuestionIdAnswerId implements Serializable{

    public ModuleIdQuestionIdAnswerId(){}

    public ModuleIdQuestionIdAnswerId(Modules modules, Questions questions, Answers answers){
        this.moduleId = modules;
        this.questionId = questions;
        this.answerId = answers;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "MODULE_ID")
    private Modules moduleId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "QUESTION_ID")
    private Questions questionId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ANSWER_ID")
    private Answers answerId;

    public Modules getModuleId() {
        return moduleId;
    }

    public void setModuleId(Modules moduleId) {
        this.moduleId = moduleId;
    }

    public Questions getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Questions questionId) {
        this.questionId = questionId;
    }

    public Answers getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Answers answerId) {
        this.answerId = answerId;
    }
}
