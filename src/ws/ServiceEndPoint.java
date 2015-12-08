package ws;

import model.*;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService(name = "java2_server")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface ServiceEndPoint {

    // USER START
    @WebMethod
    public void createUser(@WebParam(name = "newuser") User newUser) throws Exception;

    @WebMethod
    public User login(@WebParam(name = "email") String email, @WebParam(name = "password") String password) throws Exception;

    @WebMethod
    public void lostPassword(@WebParam(name = "email") String email) throws Exception;

    @WebMethod
    public void updateUser(@WebParam(name = "user") User user) throws Exception;

    @WebMethod
    public User getUserByEmailAddress(@WebParam(name = "email") String email) throws Exception;

    @WebMethod
    public void deleteUser(@WebParam(name = "user") User user) throws Exception;
    // USER END

    // MESSAGE START
    @WebMethod
    public void sendMessage(@WebParam(name = "message") Message message) throws Exception;

    @WebMethod
    public Wrapper<Message> getOutMessages(@WebParam(name = "userId") Long id ) throws Exception;

    @WebMethod
    public Wrapper<Message> getInMessages(@WebParam(name = "userId") Long id ) throws Exception;

    @WebMethod
    public void updateMessage(@WebParam(name = "message") Message message) throws Exception;

    public void deleteMessages(@WebParam(name = "message") Message message) throws Exception;
    // MESSAGE END

    // GROUPSERVICE START
    @WebMethod
    public void create(@WebParam(name = "group") Group group) throws Exception;

    @WebMethod
    public void delete(@WebParam(name = "group") Group group) throws Exception;

    @WebMethod
    public void joinToGroup(@WebParam(name = "group") Group group, @WebParam(name = "user") User user) throws Exception;

    @WebMethod
    public void leveGroup(@WebParam(name = "group")Group group, @WebParam(name = "user") User user) throws Exception;

    @WebMethod
    public Wrapper<User> getUsersByGroup(@WebParam(name = "group") Group group) throws Exception;

    @WebMethod
    public Wrapper<Event> getEventsByGroup(@WebParam(name = "group") Group group) throws Exception;

    @WebMethod
    public Wrapper<Group> getAllGroup() throws Exception;
    // GROUPSERVICE END

    // EVENTSERVICE START
    @WebMethod
    public void createEvent(@WebParam(name = "event") Event event) throws Exception;

    @WebMethod
    public void deleteEvent(@WebParam(name = "event")Event event) throws Exception;

    @WebMethod
    public void updateEvent(@WebParam(name = "event")Event event) throws Exception;

    @WebMethod
    public void joinEvent(@WebParam(name = "user")User user, @WebParam(name = "event")Event event) throws Exception;

    @WebMethod
    public void leaveEvent(@WebParam(name = "user")User user, @WebParam(name = "event")Event event) throws Exception;
    // EVENTSERVICE END

    // LOCATION SERVICE START
    @WebMethod
    public void createLocation(@WebParam(name = "location") Location location) throws Exception;

    @WebMethod
    public void updateLocation(@WebParam(name = "location") Location location) throws Exception;

    @WebMethod
    public void deleteLocation(@WebParam(name = "location") Location location) throws Exception;

    public Wrapper<Location> getAllLocation() throws Exception;
    // LOCATION SERVICE END

}
