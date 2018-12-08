package domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Conversation {
    private Person sender;
    private Person recipient;
    private List<String> messages;

    public Conversation(Person sender, Person recipient) {
        setSender(sender);
        setRecipient(recipient);
        messages = new ArrayList<>();

    }

    public Person getSender() {
        return sender;
    }

    public void setSender(Person sender) {
        this.sender = sender;
    }

    public Person getRecipient() {
        return recipient;
    }

    public void setRecipient(Person recipient) {
        this.recipient = recipient;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void addMessage(String m){
     //   if (m == null){
     //       return;
       // }
     //   else {
      //      this.messages.add(m);
      //  }
        this.getMessages().add(m);
    }



}
