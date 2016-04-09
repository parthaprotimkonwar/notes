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
public class ModuleIdQuestionId implements Serializable{

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "MODULE_ID")
    private Modules moduleId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "QUESTION_ID")
    private Questions questionId;
}
