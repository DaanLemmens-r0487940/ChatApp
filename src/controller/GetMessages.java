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
        Person s = (Person)session.getAttribute("user");

        String friend = request.getParameter("friend");
        Person r = service.getPerson(friend);

        Conversation conversation = null;
        for (Conversation c : this.getPersonService().conversations){
           if (c.getSender().getUserId().equals(s.getUserId()) && c.getRecipient().getUserId().equals(r.getUserId())
           || c.getRecipient().getUserId().equals(s.getUserId()) && c.getSender().getUserId().equals(r.getUserId())){
                conversation = c;
                break;
           }
        }
        if (conversation == null){
            conversation = new Conversation(s,r);
            this.getPersonService().conversations.add(conversation);
        }

        String json = this.toJSON(conversation.getMessages());

        response.setContentType("application/json");
        response.getWriter().write(json);

        return "";
    }

    public String toJSON (List<String> list) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(list);
    }
}
