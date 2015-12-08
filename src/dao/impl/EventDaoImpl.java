package dao.impl;

import dao.EventDao;
import jpa.SessionUtil;
import model.*;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ws.Publisher;

import javax.xml.bind.annotation.XmlSeeAlso;

@XmlSeeAlso({Message.class, User.class, Group.class, Location.class, Message.class, UserGroup.class})
public class EventDaoImpl implements EventDao {

    @Override
    public void createEvent(Event event) throws Exception {
        Session session = SessionUtil.openSession();
        Transaction tx = session.beginTransaction();
        session.save(event);
        tx.commit();
        session.close();

        Publisher.LOGGER.trace("Uj esemenyt hoztak letre: " + event.getName());
    }

    @Override
    public void deleteEvent(Event event) throws Exception {
        Session session = SessionUtil.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(event);
        tx.commit();
        session.close();

        Publisher.LOGGER.trace("Egy esemenyt toroltek: " + event.getName());
    }

    @Override
    public void updateEvent(Event event) throws Exception {
        Session session = SessionUtil.openSession();
        Transaction tx = session.beginTransaction();
        session.update(event);
        tx.commit();
        session.close();

        Publisher.LOGGER.trace("Esemenyt valtoztattak: " + event.getName());
    }

    @Override
    public void joinEvent(User user, Event event) throws Exception {
        Session session = SessionUtil.openSession();
        Transaction tx = session.beginTransaction();
        user.getMyEvents().add(event);
        session.update(user);
        tx.commit();
        session.close();
    }

    @Override
    public void leaveEvent(User user, Event event) throws Exception {
        Session session = SessionUtil.openSession();
        Transaction tx = session.beginTransaction();
        user.getMyEvents().remove(event);
        session.update(user);
        tx.commit();
        session.close();
    }
}
