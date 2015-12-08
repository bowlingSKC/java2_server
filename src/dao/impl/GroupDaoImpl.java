package dao.impl;

import dao.GroupDao;
import exceptions.NoSuchGroupInDatabase;
import jpa.SessionUtil;
import model.Event;
import model.Group;
import model.User;
import model.UserGroup;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ws.Publisher;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class GroupDaoImpl implements GroupDao {

    @Override
    public void create(Group group) throws Exception {
        Session session = SessionUtil.openSession();
        Transaction tx = session.beginTransaction();
        session.save(group);
        tx.commit();
        session.close();

        Publisher.LOGGER.trace("Uj csoportot hoztak letre: " + group.getName());
    }

    @Override
    public void delete(Group group) {
        Session session = SessionUtil.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(group);
        tx.commit();
        session.close();

        Publisher.LOGGER.trace("Egy csoportot toroltek: " + group.getName());
    }

    @Override
    public void join(Group group, User user) {
        UserGroup userGroup = new UserGroup(user, group, new Date());

        Session session = SessionUtil.openSession();
        Transaction tx = session.beginTransaction();
        session.save(userGroup);
        tx.commit();
        session.close();
    }

    @Override
    public void leave(Group group, User user) throws Exception {
        Session session = SessionUtil.openSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("from User where id = :id");
        query.setParameter("id", user.getId());

        user.getMyGroups().stream().filter(ug -> ug.getGroup().equals(group)).forEach(session::delete);

        session.update(user);
        tx.commit();
        session.close();
    }

    @Override
    public List<User> getGroupUser(Group group) throws Exception {
        Session session = SessionUtil.openSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("from Group where id = :id");
        query.setParameter("id", group.getId());

        Group selected = (Group) query.uniqueResult();
        if( selected == null ) {
            throw new NoSuchGroupInDatabase();
        }

        List<User> users = selected.getUsers().stream().map(UserGroup::getUser).collect(Collectors.toList());

        tx.commit();
        session.close();

        return users;
    }

    @Override
    public List<Event> getGroupEvent(Group group) throws Exception {
        Session session = SessionUtil.openSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("from Group where id = :id");
        query.setParameter("id", group.getId());

        Group selected = (Group) query.uniqueResult();
        if( selected == null ) {
            throw new NoSuchGroupInDatabase();
        }

        tx.commit();
        session.close();

        return selected.getEvents();
    }

    @Override
    public List<Group> getAllGroup() throws Exception {
        Session session = SessionUtil.openSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("from Group");

        List<Group> groups = query.list();

        tx.commit();
        session.close();

        return groups;
    }
}
