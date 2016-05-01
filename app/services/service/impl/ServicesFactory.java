package services.service.impl;

import services.service.PersonServiceI;
import services.service.core.*;
import services.service.core.question_answers.AnswersServiceI;
import services.service.core.question_answers.ModuleQuestionAnswerServiceI;
import services.service.core.question_answers.QuestionAnswerServiceI;
import services.service.core.question_answers.QuestionsServiceI;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

@Named
@Singleton
public class ServicesFactory {

	@Inject
	public PersonServiceI personService;

	@Inject
	public SubjectsServiceI subjectsService;

	@Inject
	public AuthorsServiceI authorsService;

	@Inject
	public SubjectAuthorServiceI subjectAuthorService;

	@Inject
	public ChaptersServiceI chaptersService;

	@Inject
	public ModulesServiceI modulesService;

	@Inject
	public QuestionsServiceI questionsService;

	@Inject
	public AnswersServiceI answersService;

	@Inject
	public QuestionAnswerServiceI questionAnswerService;

	@Inject
	public ModuleQuestionAnswerServiceI moduleQuestionAnswerService;

}
