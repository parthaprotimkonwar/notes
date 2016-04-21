package startup;

import application.enums.QA_TYPE;
import application.enums.STATUS;
import application.exceptions.BaseException;
import models.core.Chapters;
import models.core.Modules;
import models.core.Subjects;
import models.core.question_answers.*;
import org.springframework.transaction.annotation.Transactional;
import repository.core.ChaptersRepository;
import repository.core.ModulesRepository;
import repository.core.SubjectsRepository;
import repository.core.question_answers.AnswersRepository;
import repository.core.question_answers.ModuleQuestionAnswersRepository;
import repository.core.question_answers.QuestionsAnswerRepository;
import repository.core.question_answers.QuestionsRepository;
import services.service.impl.ServicesFactory;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

/**
 * Bootstraps Courses/Subjects, Chapters, Questions, Answers, QuestionAnswer, ModuleQuestionAnswers, ChapterModules
 * Created by pkonwar on 4/20/2016.
 */
@Named
@Singleton
public class BootstrapCoreModules {

    @Inject
    ServicesFactory servicesFactory;

    //@PostConstruct
    public void initializeDatabase() throws BaseException {

        System.out.println("BOOTSTRAPPING DATA.... Please wait.");
        initializeSubjects();

    }

    private void initializeSubjects() throws BaseException {
        Subjects subject = new Subjects("Entrepreneurship", 120F, "images/entrepreneurship.jpg", STATUS.ACTIVE);
        subject = servicesFactory.subjectsService.addSubject(subject);

        Chapters chapter1 = new Chapters(10F, "Chapter1 of Entrepreneurship", 1, subject, STATUS.ACTIVE);
        chapter1 = servicesFactory.chaptersService.addChapter(chapter1);
        Chapters chapter2 = new Chapters(10F, "Chapter2 of Entrepreneurship", 2, subject, STATUS.ACTIVE);
        Chapters chapter3 = new Chapters(10F, "Chapter3 of Entrepreneurship", 3, subject, STATUS.ACTIVE);
        Chapters chapter4 = new Chapters(10F, "Chapter4 of Entrepreneurship", 4, subject, STATUS.ACTIVE);
        Chapters chapter5 = new Chapters(10F, "Chapter5 of Entrepreneurship", 5, subject, STATUS.ACTIVE);


        chapter2 = servicesFactory.chaptersService.addChapter(chapter2);
        chapter3 = servicesFactory.chaptersService.addChapter(chapter3);
        chapter4 = servicesFactory.chaptersService.addChapter(chapter4);
        chapter5 = servicesFactory.chaptersService.addChapter(chapter5);

        Modules modules1 = new Modules(chapter1, "DEFAULT", 1, STATUS.ACTIVE);
        Modules modules2 = new Modules(chapter2, "DEFAULT", 2, STATUS.ACTIVE);
        Modules modules3 = new Modules(chapter3, "DEFAULT", 3, STATUS.ACTIVE);
        Modules modules4 = new Modules(chapter4, "DEFAULT", 4, STATUS.ACTIVE);
        Modules modules5 = new Modules(chapter5, "DEFAULT", 5, STATUS.ACTIVE);
        modules1 = servicesFactory.modulesService.addModule(modules1);

        modules2 = servicesFactory.modulesService.addModule(modules2);
        modules3 = servicesFactory.modulesService.addModule(modules3);
        modules4 = servicesFactory.modulesService.addModule(modules4);
        modules5 = servicesFactory.modulesService.addModule(modules5);

        Questions question1 = new Questions("What is Entrepreneurship?1");
        question1 = servicesFactory.questionsService.addQuestion(question1);

        Answers answer1 = new Answers("It is a purpose of living for someone.1");
        answer1 = servicesFactory.answersService.addAnswers(answer1);

        QuestionsAnswer questionsAnswer1 = new QuestionsAnswer(question1, answer1, QA_TYPE.SHORT);
        questionsAnswer1 = servicesFactory.questionAnswerService.addQuestionAnswer(questionsAnswer1);

        Questions question2 = new Questions("What is Entrepreneurship2?");
        question2 = servicesFactory.questionsService.addQuestion(question2);

        Answers answer2 = new Answers("It is a purpose of living for someone.2");
        answer2 = servicesFactory.answersService.addAnswers(answer2);

        QuestionsAnswer questionsAnswer2 = new QuestionsAnswer(question2, answer2, QA_TYPE.SHORT);
        questionsAnswer2 = servicesFactory.questionAnswerService.addQuestionAnswer(questionsAnswer2);

        Questions question3 = new Questions("What is Entrepreneurship3?");
        question3 = servicesFactory.questionsService.addQuestion(question3);

        Answers answer3 = new Answers("It is a purpose of living for someone.3");
        answer3 = servicesFactory.answersService.addAnswers(answer3);

        QuestionsAnswer questionsAnswer3 = new QuestionsAnswer(question3, answer3, QA_TYPE.SHORT);
        questionsAnswer3 = servicesFactory.questionAnswerService.addQuestionAnswer(questionsAnswer3);

        ModuleQuestionsAnswers moduleQuestionsAnswers1 = new ModuleQuestionsAnswers(new ModuleIdQuestionsAnswersId(questionsAnswer1, modules1), 1);
        ModuleQuestionsAnswers moduleQuestionsAnswers2 = new ModuleQuestionsAnswers(new ModuleIdQuestionsAnswersId(questionsAnswer2, modules1), 2);
        ModuleQuestionsAnswers moduleQuestionsAnswers3 = new ModuleQuestionsAnswers(new ModuleIdQuestionsAnswersId(questionsAnswer3, modules1), 3);
        servicesFactory.moduleQuestionAnswerService.addQuestionAnswersToModule(moduleQuestionsAnswers1);
        servicesFactory.moduleQuestionAnswerService.addQuestionAnswersToModule(moduleQuestionsAnswers2);
        servicesFactory.moduleQuestionAnswerService.addQuestionAnswersToModule(moduleQuestionsAnswers3);
    }
}
