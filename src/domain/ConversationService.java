/*
package domain;

import java.util.ArrayList;
import java.util.List;

public class ConversationService {
    private List<Conversation> conversations;

    public ConversationService() {
        conversations = new ArrayList<>();
    }


    public List<Conversation> getConversations(){
        return conversations;
    }

    public void setConversations(List<Conversation> conversations){
        this.conversations = conversations;
    }

    public void addConversation(Conversation c){
        if (c == null){
            throw new NullPointerException("Conversation is null");
        }
        this.conversations.add(c);
    }

    public Conversation getConversation(Person s, Person r)  {
        if (s == null || r == null){
            throw new NullPointerException("Sender or Receiver is null");
        }
        for (Conversation c : this.getConversations()){
            if (c.getSender().equals(s) && c.getRecipient().equals(r) || c.getSender().equals(r) && c.getRecipient().equals(s)){
                return c;
            }
        }
       // return new Conversation(s,r);
        return  null;
    }

}
*/
