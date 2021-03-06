package ws.impl;

import dao.*;
import dao.impl.*;
import model.*;
import ws.ServiceEndPoint;
import ws.Wrapper;

import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.soap.MTOM;
import java.util.ArrayList;
import java.util.List;

@WebService(endpointInterface = "ws.ServiceEndPoint")
@MTOM(enabled = true)
@XmlSeeAlso({Message.class, User.class, Group.class, Location.class, Message.class, UserGroup.class})
public class ServiceEndPointImpl implements ServiceEndPoint {

    private UserDao userDao = new UserDaoImpl();
    private MessageDao messageDao = new MessageDaoImpl();
    private GroupDao groupDao = new GroupDaoImpl();
    private EventDao eventDao = new EventDaoImpl();
    private LocationDao locationDao = new LocationDaoImpl();

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
    public void updateUser(User user) throws Exception {
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
    public Wrapper<Message> getOutMessages(Long id) throws Exception {
        return messageDao.getOutMessages(id);
    }

    @Override
    public Wrapper<Message> getInMessages(Long id) throws Exception {
        return messageDao.getInMessages(id);
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
    public void delete(Group group) throws Exception {
        groupDao.delete(group);
    }

    @Override
    public void joinToGroup(Group group, User user) throws Exception {
        groupDao.join(group, user);
    }

    @Override
    public void leveGroup(Group group, User user) throws Exception {
        groupDao.leave(group, user);
    }

    @Override
    public Group getGroupByName(String name) throws Exception {
        return groupDao.getGroupByName(name);
    }

    @Override
    public Wrapper<User> getUsersByGroup(Group group) throws Exception {
        return groupDao.getGroupUser(group);
    }

    @Override
    public Wrapper<Event> getEventsByGroup(Group group) throws Exception {
        return groupDao.getGroupEvent(group);
    }

    @Override
    public Wrapper<Group> getAllGroup() throws Exception {
        return groupDao.getAllGroup();
    }

    @Override
    public void createEvent(Event event) throws Exception {
        eventDao.createEvent(event);
    }

    @Override
    public void deleteEvent(Event event) throws Exception {
        eventDao.deleteEvent(event);
    }

    @Override
    public void updateEvent(Event event) throws Exception {
        eventDao.updateEvent(event);
    }

    @Override
    public void joinEvent(User user, Event event) throws Exception {
        eventDao.joinEvent(user, event);
    }

    @Override
    public void leaveEvent(User user, Event event) throws Exception {
        eventDao.leaveEvent(user, event);
    }

    @Override
    public void createLocation(Location location) throws Exception {
        locationDao.createLocation(location);
    }

    @Override
    public void updateLocation(Location location) throws Exception {
        locationDao.updateLocation(location);
    }

    @Override
    public void deleteLocation(Location location) throws Exception {
        locationDao.deleteLocation(location);
    }

    @Override
    public Wrapper<Location> getAllLocation() throws Exception {
        return new Wrapper<Location>(locationDao.getAllLocation());
    }

}