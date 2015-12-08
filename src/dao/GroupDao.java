package dao;

import model.Event;
import model.Group;
import model.User;
import ws.Wrapper;

import java.util.List;

public interface GroupDao {

    public void create(Group group) throws Exception;
    public void delete(Group group);
    public void join(Group group, User user);

    public Group getGroupByName(String name) throws Exception;

    public void leave(Group group, User user) throws Exception;

    public Wrapper<User> getGroupUser(Group group) throws Exception;
    public Wrapper<Event> getGroupEvent(Group group) throws Exception;

    public Wrapper<Group> getAllGroup() throws Exception;

}
