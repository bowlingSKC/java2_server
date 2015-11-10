package dao;

import model.User;

public interface UserDao {

    public void createUser(User newUser) throws Exception;
    public void deleteUser(User user);
    public User login(String email, String password) throws Exception;
    public void lostPassword(String email) throws Exception;
    public void updateUser(User user);
    public User getUserByEmailAddress(String email) throws Exception;

}
