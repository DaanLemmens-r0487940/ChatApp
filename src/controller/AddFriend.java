package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Person;
import domain.PersonService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AddFriend extends AsynchronousRequestHandler {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        Person person = (Person) session.getAttribute("user");

        String friendUserId = request.getParameter("friendUserId");
        Person friend = null;

        if (friendUserId != null && !friendUserId.trim().isEmpty()){
            friend = this.getPersonService().getPerson(friendUserId);
        }

        if (friend != null){
            if (!person.getFriends().contains(friend)){
                person.addFriend(friend);
                friend.addFriend(person);
            }
        }

        return "";
    }
}
