package services.service.impl;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import services.service.PersonServiceI;
import services.service.core.SubjectsServiceI;

@Named
@Singleton
public class ServicesFactory {

	@Inject
	public PersonServiceI personService;

	@Inject
	public SubjectsServiceI subjectsService;

	
}
