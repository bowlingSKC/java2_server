package dao.impl;

import dao.LocationDao;
import jpa.SessionUtil;
import model.Location;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class LocationDaoImpl implements LocationDao {

    @Override
    public void createLocation(Location location) throws Exception {
        Session session = SessionUtil.openSession();
        Transaction tx = session.beginTransaction();
        session.save(location);
        tx.commit();
        session.close();
    }

    @Override
    public void deleteLocation(Location location) throws Exception {
        Session session = SessionUtil.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(location);
        tx.commit();
        session.close();
    }

    @Override
    public void updateLocation(Location location) throws Exception {
        Session session = SessionUtil.openSession();
        Transaction tx = session.beginTransaction();
        session.update(location);
        tx.commit();
        session.close();
    }

    @Override
    public List<Location> getAllLocation() throws Exception {
        List<Location> locations = null;
        Session session = SessionUtil.openSession();
        Query query = session.createQuery("from Location");
        locations = query.list();
        session.close();
        return locations;
    }
}
