package jpa;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class SessionUtil {

    private static SessionFactory sessionFactory = buldSessionFactory();

    private static SessionFactory buldSessionFactory() {
        try {
            Configuration configuration = new Configuration().configure();
            ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties())
                    .buildServiceRegistry();
            return configuration.buildSessionFactory(serviceRegistry);
        } catch (Throwable ex) {
            System.err.print("Hiba az adatbázis kapcsolódás közben!\n" + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session openSession() {
        return sessionFactory.openSession();
    }

}
