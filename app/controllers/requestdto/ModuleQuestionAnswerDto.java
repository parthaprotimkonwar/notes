package controllers.requestdto;

import application.enums.QA_TYPE;

import java.io.Serializable;

/**
 * Created by pkonwar on 6/24/2016.
 */
public class ModuleQuestionAnswerDto implements Serializable {

    public ModuleQuestionAnswerDto() {
    }

    public ModuleQuestionAnswerDto(Long questionAnswerId, Long moduleId, String question, String answer, Integer indexing) {
        this.questionAnswerId = questionAnswerId;
        this.moduleId = moduleId;
        this.question = question;
        this.answer = answer;
        this.indexing = indexing;
    }


    private Long questionAnswerId;
    private String question;
    private String answer;
    private QA_TYPE qquestionType;
    private Long subjectId;
    private Long moduleId;
    private Long chapterId;
    private Integer indexing;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public Long getModuleId() {
        return moduleId;
    }

    public void setModuleId(Long moduleId) {
        this.moduleId = moduleId;
    }

    public Long getChapterId() {
        return chapterId;
    }

    public void setChapterId(Long chapterId) {
        this.chapterId = chapterId;
    }

    public Integer getIndexing() {
        return indexing;
    }

    public void setIndexing(Integer indexing) {
        this.indexing = indexing;
    }

    public Long getQuestionAnswerId() {
        return questionAnswerId;
    }

    public void setQuestionAnswerId(Long questionAnswerId) {
        this.questionAnswerId = questionAnswerId;
    }
}
