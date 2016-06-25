package rest.dto;

import models.bean.core.question_answers.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pkonwar on 4/30/2016.
 */
public class QuestionAnswerDto implements Serializable{

    private List<QuestionsBean> questions = new ArrayList<>();

    private List<AnswersBean> answers = new ArrayList<>();

    private List<QuestionsAnswerBean> questionAnswer = new ArrayList<>();

    private List<QuestionOptionsBean> questionOptions = new ArrayList<>();

    private List<ModuleQuestionsAnswersBean> moduleQuestionAnswer = new ArrayList<>();

    public List<QuestionsBean> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionsBean> questions) {
        this.questions = questions;
    }

    public List<AnswersBean> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AnswersBean> answers) {
        this.answers = answers;
    }

    public List<QuestionsAnswerBean> getQuestionAnswer() {
        return questionAnswer;
    }

    public void setQuestionAnswer(List<QuestionsAnswerBean> questionAnswer) {
        this.questionAnswer = questionAnswer;
    }

    public List<QuestionOptionsBean> getQuestionOptions() {
        return questionOptions;
    }

    public void setQuestionOptions(List<QuestionOptionsBean> questionOptions) {
        this.questionOptions = questionOptions;
    }

    public List<ModuleQuestionsAnswersBean> getModuleQuestionAnswer() {
        return moduleQuestionAnswer;
    }

    public void setModuleQuestionAnswer(List<ModuleQuestionsAnswersBean> moduleQuestionAnswer) {
        this.moduleQuestionAnswer = moduleQuestionAnswer;
    }
}
