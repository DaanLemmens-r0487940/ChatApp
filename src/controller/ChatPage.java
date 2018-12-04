package controller;


import domain.Person;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;


public class ChatPage extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        List<String> errors = new ArrayList<String>();
        if (isLoggedIn(request) == false){
            errors.add("You have to be logged in to go to the chat page.");
            request.setAttribute("errors", errors);
            return "index.jsp";

        }
        else {
            return "chatPage.jsp";
        }

    }


    protected boolean isLoggedIn(HttpServletRequest request) {
        Person person = (Person) request.getSession().getAttribute("user");
        if (person != null) {
            return true;
        }
        return false;
    }
}
