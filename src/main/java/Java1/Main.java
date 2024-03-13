package Java1;

import Java1.Entity.User;
import Java1.Service.Impl.UserServiceImpl;
import Java1.Service.UserService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        User user = new User("Jandar", "Taalaibekov", 22, "xp3335@gmail.com");
        User user1 = new User("Aidar", "Taalaibekov", 15, "Aidar@gmail.com");
        UserService userService = new UserServiceImpl();
//        userService.addNewUser(user);
//        userService.addNewUser(user1);
        User u = userService.getUserById(1);
       // userService.updateUserById(1,user);
       // userService.deleteUserById(2);
//        userService.deleteAllUsers();
//        List<User> allUser = userService.getAllUser();
//        for (User us : allUser) {
//            System.out.println("=========================================");
//            System.out.println("ID пользователя: " + us.getId());
//            System.out.println("Имя пользователя: " + us.getFirst_name());
//            System.out.println("Фамилия пользователя: " + us.getLast_name());
//            System.out.println("Email пользователя: " + us.getEmail());
//            System.out.println("Возраст пользователя: " + us.getAge());
//            System.out.println("=========================================");
//
//        }
        User jandar = userService.getUserByFirstName("Jandar");
        System.out.println(jandar);



    }
}
