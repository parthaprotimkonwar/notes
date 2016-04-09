package models.core.question_answers;

import utilities.Constants;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by pkonwar on 4/9/2016.
 */

@Entity
@Table(name = "ANSWER", schema = Constants.SCHEMA_NAME_CORE_MODULES_QA)
public class Answers implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ANSWER_ID")
    private Long answerId;

    @Column(name = "ANSWER", nullable = false)
    @Lob
    private String answer;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<ModuleQuestions> moduleQuestions;

    public Long getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Long answerId) {
        this.answerId = answerId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
