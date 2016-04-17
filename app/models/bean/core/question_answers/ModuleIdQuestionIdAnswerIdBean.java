package models.bean.core.question_answers;

import models.bean.core.ModulesBean;

import java.io.Serializable;

/**
 * Created by pkonwar on 4/9/2016.
 */
public class ModuleIdQuestionIdAnswerIdBean implements Serializable {

    public ModuleIdQuestionIdAnswerIdBean(ModulesBean modulesBean, QuestionsBean questionsBean, AnswersBean answersBean) {
        this.modulesBean = modulesBean;
        this.questionsBean = questionsBean;
        this.answersBean = answersBean;
    }

    private ModulesBean modulesBean;

    private QuestionsBean questionsBean;

    private AnswersBean answersBean;

    public ModulesBean getModulesBean() {
        return modulesBean;
    }

    public void setModulesBean(ModulesBean modulesBean) {
        this.modulesBean = modulesBean;
    }

    public QuestionsBean getQuestionsBean() {
        return questionsBean;
    }

    public void setQuestionsBean(QuestionsBean questionsBean) {
        this.questionsBean = questionsBean;
    }

    public AnswersBean getAnswersBean() {
        return answersBean;
    }

    public void setAnswersBean(AnswersBean answersBean) {
        this.answersBean = answersBean;
    }
}
