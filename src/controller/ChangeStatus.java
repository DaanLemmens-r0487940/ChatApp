package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Person;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ChangeStatus extends AsynchronousRequestHandler{


    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException{
        String status = request.getParameter("status");
        if (status.trim().isEmpty() || status == null){
            status = "Online";
        }
        HttpSession session = request.getSession();
        Person person = (Person) session.getAttribute("user");
        person.setStatus(status);

        String json = this.toJSON(person);
        return json;
    }

    public String toJSON (Person person) throws JsonProcessingException{
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(person);
    }
}
