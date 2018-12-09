package controller;

import db.DbException;
import domain.DomainException;
import domain.Person;
import domain.PersonService;
import domain.Role;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SignUp extends RequestHandler{


    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PersonService service = super.getPersonService();

        Person user = new Person();
        List<String> errors = new ArrayList<>();

        processUserid(user, request, errors);
        processPassword(user, request, errors);
        processFirstName(user, request, errors);
        processLastName(user, request, errors);
        processGender(user, request, errors);
        processAge(user, request, errors);
        user.setRole(Role.LID);

        if (errors.size() == 0){
            try{
                service.addPerson(user);
            }catch(DbException e){
                errors.add(e.getMessage());
            }

        }

        if (errors.size() > 0){
            request.setAttribute("errorsSignUp", errors);
            String email = request.getParameter("newEmail");
            String firstName = request.getParameter("newFirstName");
            String lastName = request.getParameter("newLastName");
            String gender = request.getParameter("newGender");
            String age = request.getParameter("newAge");
            request.setAttribute("newEmail",email);
            request.setAttribute("newFirstName",firstName);
            request.setAttribute("newLastName",lastName);
            request.setAttribute("newGender",gender);
            request.setAttribute("newAge",age);
            //request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        else {
            request.setAttribute("success", "User " + user.getUserId() + " is added. You can now log in." );
        }

        return "";
    }


    private void processAge(Person user, HttpServletRequest request, List<String> errors) {
        try {
            String age = request.getParameter("newAge");
            user.setAgeString(age);
        }
        catch(DomainException e) {
            errors.add(e.getMessage());
        }
        catch(NumberFormatException e){
            errors.add(e.getMessage());
        }
    }

    private void processGender(Person user, HttpServletRequest request, List<String> errors) {
        try {
            String gender = request.getParameter("newGender");
            user.setGender(gender);
        }
        catch(DomainException e) {
            errors.add(e.getMessage());
        }
    }

    private void processLastName(Person user, HttpServletRequest request, List<String> errors) {
        try {
            String lastName = request.getParameter("newLastName");
            user.setLastName(lastName);
        }
        catch(DomainException e) {
            errors.add(e.getMessage());
        }
    }

    private void processFirstName(Person user, HttpServletRequest request, List<String> errors) {
        try {
            String firstName = request.getParameter("newFirstName");
            user.setFirstName(firstName);
        }
        catch(DomainException e) {
            errors.add(e.getMessage());
        }
    }

    private void processPassword(Person user, HttpServletRequest request, List<String> errors) {
        try {
            String password = request.getParameter("newPassword");
            String passwordRepeat = request.getParameter("newPasswordRepeat");
            if (password.equals(passwordRepeat)){
                user.setHashedPassword(password);
            }
            else {
                errors.add("the passwords must be the same");
            }

        }
        catch(DomainException e) {
            errors.add(e.getMessage());
        }
    }

    private void processUserid(Person user, HttpServletRequest request, List<String> errors) {
        try {
            String email = request.getParameter("newEmail");
            user.setUserId(email);
        }
        catch(DomainException e) {
            errors.add(e.getMessage());
        }
    }
}
