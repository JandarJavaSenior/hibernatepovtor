package Java1.Dao;

import Java1.Entity.User;

import java.util.List;

public interface UserDao {
    User addNewUser(User user);
    User getUserById(long id);
    User updateUserById(long id ,User user);
    void deleteUserById(long id);
    void deleteAllUsers();
    List<User> getAllUser();
    User getUserByFirstName(String firstName);
}
