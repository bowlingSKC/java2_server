package dao;

import model.Event;

public interface EventDao {

    public void createEvent(Event event) throws Exception;
    public void deleteEvent(Event event) throws Exception;
    public void updateEvent(Event event) throws Exception;

}
