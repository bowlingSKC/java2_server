package dao;


import model.Message;

public interface MessageDao {

    public void sendMessage(Message message);
    public void deleteMessage(Message message);
    public void updateMessage(Message message);

}
