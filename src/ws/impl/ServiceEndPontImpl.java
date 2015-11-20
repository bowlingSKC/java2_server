package ws.impl;

import dao.GroupDao;
import dao.MessageDao;
import dao.UserDao;
import dao.impl.GroupDaoImpl;
import dao.impl.MessageDaoImpl;
import dao.impl.UserDaoImpl;
import model.Group;
import model.Message;
import model.User;
import ws.ServiceEndPoint;

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

@WebService(endpointInterface = "ws.ServiceEndPoint")
public class ServiceEndPontImpl implements ServiceEndPoint {

    private UserDao userDao = new UserDaoImpl();
    private MessageDao messageDao = new MessageDaoImpl();
    private GroupDao groupDao = new GroupDaoImpl();

    @Override
    public void createUser(User newUser) throws Exception {
        userDao.createUser(newUser);
    }

    @Override
    public User login(String email, String password) throws Exception {
        return userDao.login(email, password);
    }

    @Override
    public void lostPassword(String email) throws Exception {
        userDao.lostPassword(email);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public User getUserByEmailAddress(String email) throws Exception {
        return userDao.getUserByEmailAddress(email);
    }

    @Override
    public void deleteUser(User user) throws Exception {
        userDao.deleteUser(user);
    }

    @Override
    public void sendMessage(Message message) throws Exception {
        messageDao.sendMessage(message);
    }

    @Override
    public ArrayList<Message> getOutMessages(Long id) throws Exception {
        return new ArrayList<>(messageDao.getOutMessages(id));
    }

    @Override
    public ArrayList<Message> getInMessages(Long id) throws Exception {
        return new ArrayList<>(messageDao.getInMessages(id));
    }

    @Override
    public void updateMessage(Message message) throws Exception {
        messageDao.updateMessage(message);
    }

    @Override
    public void deleteMessages(Message message) throws Exception {
        messageDao.deleteMessage(message);
    }

    @Override
    public void create(Group group) throws Exception {
        groupDao.create(group);
    }

    @Override
    public void delete(Group group) {
        groupDao.delete(group);
    }

    @Override
    public void joinToGroup(Group group, User user) {
        groupDao.join(group, user);
    }

    @Override
    public void leveGroup(Group group, User user) throws Exception {
        groupDao.leave(group, user);
    }

}
