package domain;

import java.util.ArrayList;
import java.util.List;

import db.PersonRepository;
import db.PersonRepositoryStub;

public class PersonService {
	private PersonRepository personRepository = new PersonRepositoryStub();
	public List<Conversation> conversations = new ArrayList<>();

	public PersonService(){
	}

	//USERS
	public Person getPerson(String personId)  {
		return getPersonRepository().get(personId);
	}

	public List<Person> getPersons() {
		return getPersonRepository().getAll();
	}

	public void addPerson(Person person) {
		getPersonRepository().add(person);
	}
	
	public Person getAuthenticatedUser(String email, String password) {
		return getPersonRepository().getAuthenticatedUser(email, password);
	}

	private PersonRepository getPersonRepository() {
		return personRepository;
	}


	//not implemented
	public void updatePersons(Person person) {
		getPersonRepository().update(person);
	}
	//not implemented
	public void deletePerson(String id) {
		getPersonRepository().delete(id);
	}
}
