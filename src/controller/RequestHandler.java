package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.PersonService;
import domain.Person;
import domain.Role;

import java.io.IOException;

public abstract class RequestHandler {
	
	private PersonService personService;
	
	public abstract String handleRequest (HttpServletRequest request, HttpServletResponse response) throws IOException;
	
	public void setModel (PersonService personService) {
		this.personService = personService;
	}

	public PersonService getPersonService() {
		return personService;
	}
}
