package DAO;

import model.Role;
import model.User;

import java.util.List;

public interface UserDAO {

    // Добавление нового пользователя с ролями в БД
    void create(User user);

    // Получение пользователя по id  из БД
    User findById(int id);

    // Получение списка пользователей по конкретной роли из БД
    List<User> findUserByRole(String setParameterQueryRole);

    // Получение списка ролей по конкретному пользователю из БД
    List<Role> findRoleByUser(String setParameterQueryUser);

    // Получение списка пользователей из БД (без ролей)
    List<User> findAll();

    // Редактирование существующего пользователя в БД
    void update(User user);

    // Удаление пользователя в БД
    void delete(User user);
}
