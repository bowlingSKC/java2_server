package ws;

import jpa.SessionUtil;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import ws.impl.ServiceEndPointImpl;

import javax.xml.ws.Endpoint;

public class Publisher {

    public final static Logger LOGGER = Logger.getLogger(Publisher.class);

    public static void main(String[] args) {

        Session session = SessionUtil.openSession();
        session.close();

        Endpoint.publish("http://localhost:4444/ws/ep", new ServiceEndPointImpl());
        System.out.println("Server listening ...");

    }

}
