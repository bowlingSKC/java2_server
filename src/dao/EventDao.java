package dao;

import model.Event;
import model.User;

public interface EventDao {

    public void createEvent(Event event) throws Exception;
    public void deleteEvent(Event event) throws Exception;
    public void updateEvent(Event event) throws Exception;

    public void joinEvent(User user, Event event) throws Exception;
    public void leaveEvent(User user, Event event) throws Exception;

}
