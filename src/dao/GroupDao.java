package dao;

import model.Event;
import model.Group;
import model.User;

import java.util.List;

public interface GroupDao {

    public void create(Group group) throws Exception;
    public void delete(Group group);
    public void join(Group group, User user);

    public void leave(Group group, User user) throws Exception;

    public List<User> getGroupUser(Group group) throws Exception;
    public List<Event> getGroupEvent(Group group) throws Exception;

    public List<Group> getAllGroup() throws Exception;

}
