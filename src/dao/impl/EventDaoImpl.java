package dao.impl;

import dao.EventDao;
import jpa.SessionUtil;
import model.Event;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class EventDaoImpl implements EventDao {

    @Override
    public void createEvent(Event event) throws Exception {
        Session session = SessionUtil.openSession();
        Transaction tx = session.beginTransaction();
        session.save(event);
        tx.commit();
        session.close();
    }

    @Override
    public void deleteEvent(Event event) throws Exception {
        Session session = SessionUtil.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(event);
        tx.commit();
        session.close();
    }

    @Override
    public void updateEvent(Event event) throws Exception {
        Session session = SessionUtil.openSession();
        Transaction tx = session.beginTransaction();
        session.update(event);
        tx.commit();
        session.close();
    }
}
