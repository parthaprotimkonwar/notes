package models.bean.core.question_answers;

import application.enums.QA_TYPE;

import java.io.Serializable;

/**
 * Created by pkonwar on 4/9/2016.
 */
public class ModuleQuestionsBean implements Serializable {

    public ModuleQuestionsBean() {}

    public ModuleQuestionsBean(ModuleIdQuestionIdAnswerIdBean moduleIdQuestionIdAnswerIdBean, QA_TYPE type, Integer indexing) {
        this.moduleIdQuestionIdAnswerIdBean = moduleIdQuestionIdAnswerIdBean;
        this.type = type;
        this.indexing = indexing;
    }

    private ModuleIdQuestionIdAnswerIdBean moduleIdQuestionIdAnswerIdBean;

    private QA_TYPE type;

    private Integer indexing;

    public ModuleIdQuestionIdAnswerIdBean getModuleIdQuestionIdAnswerIdBean() {
        return moduleIdQuestionIdAnswerIdBean;
    }

    public void setModuleIdQuestionIdAnswerIdBean(ModuleIdQuestionIdAnswerIdBean moduleIdQuestionIdAnswerIdBean) {
        this.moduleIdQuestionIdAnswerIdBean = moduleIdQuestionIdAnswerIdBean;
    }

    public QA_TYPE getType() {
        return type;
    }

    public void setType(QA_TYPE type) {
        this.type = type;
    }

    public Integer getIndexing() {
        return indexing;
    }

    public void setIndexing(Integer indexing) {
        this.indexing = indexing;
    }
}
