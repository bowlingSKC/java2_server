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
    public User login(String email, String password) {
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
    public void sendMessage(Message message) throws Exception {
        messageDao.sendMessage(message);
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
}
