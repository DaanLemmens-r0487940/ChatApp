package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Conversation {
    private Person sender;
    private Person recipient;
    private List<Message> messages;

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

    public List<Message> getMessages() {
        return messages;
    }

    public void addMessage(Message m){
        if (m == null){
            return;
        }
        else {
            this.messages.add(m);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Conversation){
            Conversation c = (Conversation) o;
            if (c.getSender().equals(this.getSender()) && c.getRecipient().equals(this.getRecipient()) && c.getMessages().equals(this.messages)){
                return true;
            }
        }
        return false;

    }

}
