package dao;

import model.Group;
import model.User;

public interface GroupDao {

    public void create(Group group) throws Exception;
    public void delete(Group group);
    public void join(Group group, User user);

}
