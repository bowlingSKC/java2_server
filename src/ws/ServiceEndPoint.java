package ws;

import model.Group;
import model.Message;
import model.User;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlList;
import java.util.List;

@WebService(name = "java2_server")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use=SOAPBinding.Use.LITERAL)
public interface ServiceEndPoint {

    // USER START
    @WebMethod
    public void createUser(@WebParam(name = "newuser") User newUser) throws Exception;

    @WebMethod
    public User login(@WebParam(name = "email") String email, @WebParam(name = "password") String password) throws Exception;

    @WebMethod
    public void lostPassword(@WebParam(name = "email") String email) throws Exception;

    @WebMethod
    public void updateUser(@WebParam(name = "user") User user);

    @WebMethod
    public User getUserByEmailAddress(@WebParam(name = "email") String email) throws Exception;

    @WebMethod
    public void deleteUser(@WebParam(name = "user") User user) throws Exception;
    // USER END

    // MESSAGE START
    @WebMethod
    public void sendMessage(@WebParam(name = "message") Message message) throws Exception;

    @WebMethod
    public List<Message> getOutMessages(@WebParam(name = "userId") Long id ) throws Exception;

    @WebMethod
    public List<Message> getInMessages(@WebParam(name = "userId") Long id ) throws Exception;

    @WebMethod
    public void updateMessage(@WebParam(name = "message") Message message) throws Exception;

    public void deleteMessages(@WebParam(name = "message") Message message) throws Exception;
    // MESSAGE END

    // GROUPSERVICE STAR
    @WebMethod
    public void create(@WebParam(name = "group") Group group) throws Exception;

    @WebMethod
    public void delete(@WebParam(name = "group") Group group);

    @WebMethod
    public void joinToGroup(@WebParam(name = "group") Group group, @WebParam(name = "user") User user);
    // GROUPSERVICE END

}
