package domain;

import java.util.ArrayList;
import java.util.List;

import db.PersonRepository;
import db.PersonRepositoryStub;

public class PersonService {
	private PersonRepository personRepository = new PersonRepositoryStub();
//	private ConversationService cService = new ConversationService();
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

	public void updatePersons(Person person) {
		getPersonRepository().update(person);
	}

	public void deletePerson(String id) {
		getPersonRepository().delete(id);
	}
	
	public Person getAuthenticatedUser(String email, String password) {
		return getPersonRepository().getAuthenticatedUser(email, password);
	}

	private PersonRepository getPersonRepository() {
		return personRepository;
	}

	/*//CONVERSATIONS
	public Conversation getConversation(Person s, Person r){
		return cService.getConversation(s,r);
	}

	public List<Conversation> getConversations(){
		return cService.getConversations();
	}

*//*	//makes new conversation if there isn't yet a conversation initiated by these 2 users
	public void addMessageToConversation(Person s, Person r, Message m){
		cService.getConversation(s,r).addMessage(m);
	}*//*

	public void addConversation(Conversation c){
		cService.addConversation(c);
	}

	public void addMessage(Person s, Person r, Message m){
		this.getConversation(s, r).addMessage(m);
	}
*/}
