package models.core.question_answers;

import models.core.Modules;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by pkonwar on 4/17/2016.
 */
@Embeddable
public class ModuleIdQuestionsAnswersId implements Serializable{

    public ModuleIdQuestionsAnswersId(QuestionsAnswer questionsAnswer, Modules module) {
        this.questionsAnswer = questionsAnswer;
        this.module = module;
    }

    public ModuleIdQuestionsAnswersId() {
    }

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "QUESTION_ANSWER_ID")
    private QuestionsAnswer questionsAnswer;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "MODULE_ID")
    private Modules module;

    public QuestionsAnswer getQuestionsAnswer() {
        return questionsAnswer;
    }

    public void setQuestionsAnswer(QuestionsAnswer questionsAnswer) {
        this.questionsAnswer = questionsAnswer;
    }

    public Modules getModule() {
        return module;
    }

    public void setModule(Modules module) {
        this.module = module;
    }
}
