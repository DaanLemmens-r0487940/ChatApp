package controller;

import domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BlogPage extends RequestHandler{

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<String> errors = new ArrayList<>();
        if (isLoggedIn(request) == false){
            errors.add("You have to be logged in to go to the blog page.");
            request.setAttribute("errors", errors);
            return "index.jsp";
        }
        return "blogPage.jsp";
    }

    protected boolean isLoggedIn(HttpServletRequest request) {
        Person person = (Person) request.getSession().getAttribute("user");
        if (person != null) {
            return true;
        }
        return false;
    }
}
