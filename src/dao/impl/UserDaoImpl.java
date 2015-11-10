package dao.impl;

import dao.UserDao;
import exceptions.BadLoginException;
import exceptions.EmailAlreadyExistsInDatabaseException;
import exceptions.NoSuchEmailInDatabase;
import jpa.SessionUtil;
import model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class UserDaoImpl implements UserDao {

    @Override
    public void createUser(User newUser) throws Exception {
        Session session = SessionUtil.openSession();

        Query query = session.createQuery("from User where email = :email");
        query.setParameter("email", newUser.getEmail());
        User indb = (User) query.uniqueResult();

        if( indb != null ) {
            session.close();
            throw new EmailAlreadyExistsInDatabaseException();
        }


        Transaction tx = session.beginTransaction();
        session.save(newUser);
        tx.commit();
        session.close();

        System.out.println("User created.");
    }

    @Override
    public void deleteUser(User user) {
        Session session = SessionUtil.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(user);
        tx.commit();
        session.close();

        System.out.println("User deleted.");
    }

    @Override
    public User login(String email, String password) throws Exception {
        Session session = SessionUtil.openSession();
        Query query = session.createQuery("from User where email = :mail");
        query.setParameter("mail", email);
        User selected = (User) query.uniqueResult();
        if( selected == null ) {
            System.out.println("nincs talalat");
            throw new BadLoginException();
        }

        if( !selected.getPassword().equals(password) ) {
            System.out.println("rossz adatok");
            throw new BadLoginException();
        }

        session.close();
        return selected;
    }

    @Override
    public void lostPassword(String email) throws Exception {
        Session session = SessionUtil.openSession();
        Query query = session.createQuery("from User where email = :mail");
        query.setParameter("mail", email);
        User user = (User) query.uniqueResult();
        session.close();
        if( user == null ) {
            throw new NoSuchEmailInDatabase();
        }

        // E-mail kikuldese
        sendEmail(user.getEmail(), "Új jelszó", "Az uj jelszavad: kabbeafaszom");

        user.setPassword("kabbeafaszom");
        updateUser(user);
    }

    @Override
    public void updateUser(User user) {
        Session session = SessionUtil.openSession();
        Transaction tx = session.beginTransaction();
        session.update(user);
        tx.commit();
        session.close();
    }

    @Override
    public User getUserByEmailAddress(String email) throws Exception {
        Session session = SessionUtil.openSession();
        Query query = session.createQuery("from User where email = :mail");
        query.setParameter("mail", email);
        User user = (User) query.uniqueResult();
        session.close();
        if( user == null ) {
            throw new NoSuchEmailInDatabase();
        }

        System.out.println( user );

        return user;
    }

    private void sendEmail(String recipientEmail, String title, String mymessage) {
        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        javax.mail.Session session = javax.mail.Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("projekt.penzugy", "projektlabor");
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("projekt.penzugy"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(recipientEmail));
            message.setSubject(title);
            message.setText(mymessage);

            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

}
