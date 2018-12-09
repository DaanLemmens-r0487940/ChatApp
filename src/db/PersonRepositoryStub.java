package db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.Conversation;
import domain.Message;
import domain.Person;
import domain.Role;

public class PersonRepositoryStub implements PersonRepository {
	private Map<String, Person> persons = new HashMap<String, Person>();
	private ArrayList<Conversation> conversations = new ArrayList<>();
	
	public PersonRepositoryStub () {
		Person administrator = new Person("bib@ucll.be", "t", "Bib", "Liothekaris", Role.BIB, 999, "Male");
		add(administrator);
		Person jan = new Person("jan@ucll.be", "t", "Jan", "Janssens", Role.LID, 30, "Male");
		add(jan);
		Person an = new Person("an@ucll.be", "t", "An", "Cornelissen", Role.LID, 20,"Female");
		add(an);

		administrator.addFriend(jan);
		administrator.addFriend(an);

		jan.addFriend(administrator);
		jan.addFriend(an);

		an.addFriend(administrator);
		an.addFriend(jan);


		//NEW FRIENDS?

		/*Person test1 = new Person("test1@ucll.be", "t", "test1", "1", Role.LID);
		Person test2 = new Person("test2@ucll.be", "t", "test2", "2", Role.LID);
		Person test3 = new Person("test3@ucll.be", "t", "test3", "3", Role.LID);
		Person test4 = new Person("test4@ucll.be", "t", "test4", "4", Role.LID);
		add(test1);
		add(test2);
		add(test3);
		add(test4);*/
	}
	
	public Person get(String personId){
		if(personId == null){
			throw new DbException("No personid given");
		}
		return persons.get(personId);
	}
	
	public List<Person> getAll(){
		return new ArrayList<Person>(persons.values());	
	}

	public void add(Person person){
		if(person == null){
			throw new DbException("No person given");
		}
		if (persons.containsKey(person.getUserId())) {
			throw new DbException("User already exists");
		}
		persons.put(person.getUserId(), person);
	}
	
	public void update(Person person){
		if(person == null){
			throw new DbException("No person given");
		}
		persons.put(person.getUserId(), person);
	}
	
	public void delete(String personId){
		if(personId == null){
			throw new DbException("No id given");
		}
		persons.remove(personId);
	}
	
	public Person getAuthenticatedUser(String email, String password) {
		Person person = get(email);
		
		if (person != null && person.isCorrectPassword(password)) {
			return person;
		}
		else {
			return null;
		}
	}
}
