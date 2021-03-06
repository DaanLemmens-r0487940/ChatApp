package domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Person {

	private String userId;
	private String password;
	private String salt;
	private String firstName;
	private String lastName;
	private int age;
	private String gender;
	private Role role;
	private List<Person> friends = new ArrayList<Person>();
	//When a user is added, he is set offline
	private String status = "Offline";

	public Person(String userId, String password, String firstName,
			String lastName,Role role, int age, String gender) {
		setUserId(userId);
		setHashedPassword(password);
		setFirstName(firstName);
		setLastName(lastName);
		setRole(role);
		setAge(age);
		setGender(gender);
	}

	public Person(String userId, String password, String salt,
			String firstName, String lastName,Role role, int age, String gender) {
		setUserId(userId);
		setPassword(password);
		setSalt(salt);
		setFirstName(firstName);
		setLastName(lastName);
		setRole(role);
		setAge(age);
		setGender(gender);
	}

	public Person() {
	}

	//roles arent important in this app, maybe with editing users, but now you just have to log in to get access to the rest of the applications
	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role=role;
	}

	public void setUserId(String userId) {
		if (userId.isEmpty()) {
			throw new DomainException("No id given");
		}
		String USERID_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		Pattern p = Pattern.compile(USERID_PATTERN);
		Matcher m = p.matcher(userId);
		if (!m.matches()) {
			throw new DomainException("Email not valid");
		}
		this.userId = userId;
	}

	public String getUserId() {
		return userId;
	}

	public String getPassword() {
		return password;
	}

	public boolean isCorrectPassword(String password) {
		if (password.isEmpty()) {
			throw new DomainException("No password given");
		}
		return getPassword().equals(hashPassword(password, getSalt()));
	}

	public void setPassword(String password) {
		if (password.isEmpty()) {
			throw new DomainException("No password given");
		}
		this.password = password;
	}

	public void setHashedPassword(String password) {
		if (password.isEmpty()) {
			throw new DomainException("No password given");
		}
		this.password = hashPassword(password);
	}

	private String hashPassword(String password) {
		SecureRandom random = new SecureRandom();
		byte[] seed = random.generateSeed(20);

		String salt = new BigInteger(1, seed).toString(16);
		this.setSalt(salt);

		return hashPassword(password, salt);
	}

	private String hashPassword(String password, String seed) {
		String hashedPassword = null;
		try {
			MessageDigest crypt = MessageDigest.getInstance("SHA-1");
			crypt.reset();
			crypt.update(salt.getBytes("UTF-8"));
			crypt.update(password.getBytes("UTF-8"));
			hashedPassword = new BigInteger(1, crypt.digest()).toString(16);
		} catch (NoSuchAlgorithmException e) {
			throw new DomainException(e.getMessage(), e);
		} catch (UnsupportedEncodingException e) {
			throw new DomainException(e.getMessage(), e);
		}
		return hashedPassword;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getSalt() {
		return salt;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		if (firstName.isEmpty()) {
			throw new DomainException("No firstname given");
		}
		this.firstName = firstName;// firstName;

	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		if (lastName.isEmpty()) {
			throw new DomainException("No last name given");
		}
		this.lastName = lastName;
	}

	//STATUS
	public String getStatus(){
		return status;
	}

	public void setStatus(String status){
		this.status = status;
	}

	//FRIENDS
	public void setFriends(List<Person> friends){
		this.friends = friends;
	}

	@JsonIgnore
	public List<Person> getFriends(){
		return friends;
	}

	public void addFriend(Person person){
		this.getFriends().add(person);
	}

	public void setAgeString(String age) {
		if (age.isEmpty()){throw new DomainException("No age given");}
		setAge(Integer.valueOf(age));
	}

	public void setAge(int age) {
		if (age < 0){throw new DomainException("Age must be higher dan 0");}
		this.age = age;
	}

	public int getAge(){
		return age;
	}


	public void setGender(String gender) {
		if (gender == null || gender.trim().isEmpty()){
			throw new DomainException("no email given");
		}
		this.gender = gender;
	}

	public String getGender(){
		return gender;
	}
}
