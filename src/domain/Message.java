package domain;

public class Message {
    private Person sender;
    private String message;

    public Message(Person sender, String message) {
        this.setSender(sender);
        this.setMessage(message);
    }

    public Person getSender() {
        return sender;
    }

    public void setSender(Person sender) {
        this.sender = sender;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
