package dao.impl;

import dao.GroupDao;
import jpa.SessionUtil;
import model.Group;
import model.User;
import model.UserGroup;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;

public class GroupDaoImpl implements GroupDao {

    @Override
    public void create(Group group) throws Exception {
        Session session = SessionUtil.openSession();
        Transaction tx = session.beginTransaction();
        session.save(group);
        tx.commit();
        session.close();
    }

    @Override
    public void delete(Group group) {
        Session session = SessionUtil.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(group);
        tx.commit();
        session.close();
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
        
    }
}
