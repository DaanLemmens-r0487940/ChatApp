package controller;


import db.PersonRepository;
import db.PersonRepositoryStub;
import domain.Person;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.PersonService;

public class GetFriends extends AsynchronousRequestHandler {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response)throws IOException {

        HttpSession session = request.getSession();
        Person person = (Person) session.getAttribute("user");
        List<Person> friends = person.getFriends();
//        for (Person f: friends){
//            System.out.println("Firstname: " + f.getFirstName() + " Status: " + f.getStatus());
//        }
        String json = this.toJSON(friends);
        response.getWriter().write(json);
        return "";
    }

    public String toJSON(List<Person> friends) throws IOException{
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(friends);
    }




}
