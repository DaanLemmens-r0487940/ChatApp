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

        String comment = request.getParameter("message");
        String receiver = request.getParameter("receiver");

        HttpSession session = request.getSession();
        Person s = (Person) session.getAttribute("user");
        Person r = service.getPerson(receiver);

        //sender sends a message
        Message message = new Message(s, comment);


        //add the message to the conversation
        service.addMessageToConversation(s, r, message);

        // Conversation con = null;
        //if (service.getConversation(user, recipient) == null){
            //con = new Conversation(user, recipient);
           // service.addMessageToConversation(con);
       // }
        //else {
           // con = service.getConversation(user, recipient);
       // }
        //con.addMessage(message);
        return null;
    }
}
