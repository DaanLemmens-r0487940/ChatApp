package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class GetUsers extends AsynchronousRequestHandler{

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String id = request.getParameter("userId");
        System.out.println(id);
        String json;

        if (id != null){
            Person user = getPersonService().getPerson(id);
            System.out.println(user);
            json = this.toJSON(user);
        }
        else {
            List<Person> users = getPersonService().getPersons();
            json = this.toJSON(users);
        }




        response.setContentType("application/json");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.getWriter().write(json);
        return "";
    }

    public String toJSON(Object users) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(users);
    }
}
