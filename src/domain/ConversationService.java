package domain;

import java.util.ArrayList;
import java.util.List;

public class ConversationService {
    private List<Conversation> conversations = new ArrayList<>();

    public ConversationService() {
    }


    public List<Conversation> getConversations(){
        return conversations;
    }

    public void addConversation(Conversation c){
        this.conversations.add(c);
    }

    public Conversation getConversation(Person s, Person r)  {
        for (Conversation c : conversations){
            if (c.getSender().equals(s) && c.getRecipient().equals(r) || c.getSender().equals(r) && c.getRecipient().equals(s)){
                return c;
            }
        }
        return new Conversation(s,r);
    }

    /*public void setConversations(List<Conversation> conversations) {
        this.conversations = conversations;
    }*/

}
