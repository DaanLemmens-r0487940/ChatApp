package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Conversation;
import domain.Message;
import domain.Person;
import domain.PersonService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class GetMessages extends AsynchronousRequestHandler{
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PersonService service = super.getPersonService();

        HttpSession session = request.getSession();
        Person s = (Person)request.getAttribute("user");

        String friend = request.getParameter("friend");
        Person r = service.getPerson(friend);

        Conversation c = service.getConversation(s, r);
        String json = this.toJSON(c.getMessages());

        return json;
    }

    public String toJSON (List<Message> messages) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(messages);
    }
}
