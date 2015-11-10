package dao.impl;

import dao.MessageDao;
import jpa.SessionUtil;
import model.Message;
import model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class MessageDaoImpl implements MessageDao {

    @Override
    public void sendMessage(Message message) {
        Session session = SessionUtil.openSession();
        Transaction tx = session.beginTransaction();
        session.save(message);
        tx.commit();
        session.close();
    }

    @Override
    public void deleteMessage(Message message) {
        Session session = SessionUtil.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(message);
        tx.commit();
        session.close();
    }

    @Override
    public void updateMessage(Message message) {
        Session session = SessionUtil.openSession();
        Transaction tx = session.beginTransaction();
        session.update(message);
        tx.commit();
        session.close();
    }

}
