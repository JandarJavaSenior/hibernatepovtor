package Java1.Service.Impl;

import Java1.Dao.Impl.UserDaoImpl;
import Java1.Dao.UserDao;
import Java1.Entity.User;
import Java1.Service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    public User addNewUser(User user) {
        return userDao.addNewUser(user);
    }

    public User getUserById(long id) {
        return userDao.getUserById(id);
    }

    public User updateUserById(long id, User user) {
        return userDao.updateUserById(id,user);
    }

    public void deleteUserById(long id) {
        userDao.deleteUserById(id);
        System.out.println("Delete!");
    }

    public void deleteAllUsers() {
        userDao.deleteAllUsers();
        System.out.println("All Deleted!");
    }

    public List<User> getAllUser() {
        return userDao.getAllUser();
    }

    public User getUserByFirstName(String firstName) {
        return userDao.getUserByFirstName(firstName);
    }
}
