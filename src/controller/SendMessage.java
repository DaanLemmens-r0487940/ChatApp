package controller;

import domain.Message;
import domain.Person;
import domain.PersonService;
import domain.Conversation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SendMessage extends AsynchronousRequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {

        PersonService service = super.getPersonService();

        Person s = (Person) request.getSession().getAttribute("user");
        String receiver = request.getParameter("r");
        Person r = service.getPerson(receiver);

        System.out.println("Person 1: " +s.getFirstName());
        System.out.println("Person 2: " + r.getFirstName());
        String comment = request.getParameter("m");
        System.out.println("Comment: " + comment);

        Conversation conversation = null;

        for (Conversation c : this.getPersonService().conversations) {
            if ((c.getSender().getUserId().equals(s.getUserId()) && c.getRecipient().getUserId().equals(r.getUserId())) ||
                    (c.getRecipient().getUserId().equals(s.getUserId()) && c.getSender().getUserId().equals(r.getUserId()))) {
                conversation = c;
                break;
            }
        }

        if (conversation == null){
            conversation = new Conversation(s,r);
            service.conversations.add(conversation);
        }

        if (!comment.trim().isEmpty()){
            conversation.getMessages().add(s.getFirstName() + ": " + comment);
        }

        System.out.println("Sender: " + conversation.getSender().getFirstName() +" Recepient: "+ conversation.getRecipient().getFirstName() + " MESSAGES: " + conversation.getMessages());

        return "";
    }
}
