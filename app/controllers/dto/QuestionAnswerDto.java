package controllers.dto;

import models.bean.core.question_answers.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pkonwar on 4/30/2016.
 */
public class QuestionAnswerDto implements Serializable{

    private List<QuestionsBean> questions;

    private List<AnswersBean> answers;

    private List<QuestionsAnswerBean> questionAnswer;

    private List<QuestionOptionsBean> questionOptions;

    private List<ModuleQuestionsAnswersBean> moduleQuestionAnswer;

    public List<QuestionsBean> getQuestions() {
        return questions == null ? new ArrayList<>() : questions;
    }

    public void setQuestions(List<QuestionsBean> questions) {
        this.questions = questions;
    }

    public List<AnswersBean> getAnswers() {
        return answers == null ? new ArrayList<>() : answers;
    }

    public void setAnswers(List<AnswersBean> answers) {
        this.answers = answers;
    }

    public List<QuestionsAnswerBean> getQuestionAnswer() {
        return questionAnswer == null ? new ArrayList<>() : questionAnswer;
    }

    public void setQuestionAnswer(List<QuestionsAnswerBean> questionAnswer) {
        this.questionAnswer = questionAnswer;
    }

    public List<QuestionOptionsBean> getQuestionOptions() {
        return questionOptions == null ? new ArrayList<>() : questionOptions;
    }

    public void setQuestionOptions(List<QuestionOptionsBean> questionOptions) {
        this.questionOptions = questionOptions;
    }

    public List<ModuleQuestionsAnswersBean> getModuleQuestionAnswer() {
        return moduleQuestionAnswer == null ? new ArrayList<>() : moduleQuestionAnswer;
    }

    public void setModuleQuestionAnswer(List<ModuleQuestionsAnswersBean> moduleQuestionAnswer) {
        this.moduleQuestionAnswer = moduleQuestionAnswer;
    }
}
