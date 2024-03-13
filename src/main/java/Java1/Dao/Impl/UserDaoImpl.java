package Java1.Dao.Impl;

import Java1.Dao.UserDao;
import Java1.Config.App;
import Java1.Entity.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserDaoImpl implements UserDao {

    public User addNewUser(User user) {
        Session session = App.getSession().openSession();
        session.beginTransaction();
        session.persist(user);
        session.getTransaction().commit();
        session.close();
        return user;
    }

    public User getUserById(long id) {
        Session session = App.getSession().openSession();
        session.beginTransaction();
        User user = session.get(User.class,id);
        session.getTransaction().commit();
        session.close();
        return user;
    }

    public User updateUserById(long id, User user) {
        Session session = App.getSession().openSession();
        Transaction transaction = null;
        User updatedUser = null;
        try {
            transaction = session.beginTransaction();
            User existingUser = session.get(User.class, id);
            if (existingUser != null) {
                existingUser.setFirst_name(user.getFirst_name());
                existingUser.setLast_name(user.getLast_name());
                existingUser.setAge(user.getAge());
                existingUser.setEmail(user.getEmail());
                 // Обновление сущности в базе данных
                transaction.commit();
                updatedUser = existingUser;
            } else {
                System.out.println("Пользователь с указанным идентификатором не найден.");
            }
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close(); // Закрываем сессию после завершения операций
        }
        return updatedUser;
    }


    public void deleteUserById(long id) {
        Session session = App.getSession().openSession();
        session.beginTransaction();
        User user = session.get(User.class,id);
        session.remove(user);
        session.getTransaction().commit();
        session.close();
    }

    public void deleteAllUsers() {
        Session session = App.getSession().openSession();
        session.beginTransaction();
        session.createQuery("delete from User").executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    public List<User> getAllUser() {
        Session session = App.getSession().openSession();
        session.beginTransaction();
        List users = session.createQuery("select u from User u").getResultList();
        session.getTransaction().commit();
        session.close();
        return users;
    }

    public User getUserByFirstName(String firstName) {
        Session session = App.getSession().openSession();
        session.beginTransaction();
        User user = (User) session.createQuery("from User u where u.first_name = :firstName")
                .setParameter("firstName", firstName)
                .uniqueResult();
        session.getTransaction().commit();
        session.close();
        return user;
    }

}
