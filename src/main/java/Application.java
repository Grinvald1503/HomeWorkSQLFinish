import DAO.Impl.UserDAOImpl;
import DAO.UserDAO;
import model.Role;
import model.User;

import java.sql.SQLException;

public class Application {

    public static void main(String[] args) throws SQLException {
        UserDAO userDAO = new UserDAOImpl();
        User one = new User("Первый", "login", "password");
        User two = new User("Второй", "login", "password");
        Role main = new Role("Главная");
        Role secondary = new Role("Второстепенная");
        Role absent = new Role("Отсутствует");
        one.addRole(main);
        one.addRole(secondary);
        two.addRole(secondary);
        two.addRole(absent);
        // Добавление пользователя с ролями в БД
        userDAO.create(one);
        userDAO.create(two);
        //Получение пользователей из БД(без ролей)
        userDAO.findAll().forEach(System.out::println);
        // Получение пользователя по id в БД
        System.out.println(userDAO.findById(1));

    }
}
