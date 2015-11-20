package dao;


import model.Message;
import model.User;

import java.util.List;

public interface MessageDao {

    public void sendMessage(Message message);
    public void deleteMessage(Message message);
    public void updateMessage(Message message);

    public List<Message> getOutMessages(Long id);
    public List<Message> getInMessages(Long id);

}
