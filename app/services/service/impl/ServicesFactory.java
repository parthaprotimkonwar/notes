package services.service.impl;

import services.service.PersonServiceI;
import services.service.core.ChaptersServiceI;
import services.service.core.SubjectsServiceI;
import services.service.core.question_answers.ModuleQuestionAnswerServiceI;
import services.service.core.question_answers.QuestionAnswerServiceI;

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
	public ChaptersServiceI chaptersService;

	@Inject
	public ModuleQuestionAnswerServiceI moduleQuestionAnswerService;

	@Inject
	public QuestionAnswerServiceI questionAnswerService;
}
