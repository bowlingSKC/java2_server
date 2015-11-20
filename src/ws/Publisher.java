package ws;

import jpa.SessionUtil;
import org.hibernate.Session;
import ws.impl.ServiceEndPontImpl;

import javax.xml.ws.Endpoint;

public class Publisher {

    public static void main(String[] args) {

        Session session = SessionUtil.openSession();
        session.close();

        Endpoint.publish("http://localhost:4444/ws/ep", new ServiceEndPontImpl());
        System.out.println("Server listening ...");

    }

}
