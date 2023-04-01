package DAO;

import model.Role;
import model.User;

import java.util.List;

public interface RoleDAO {

    // Добавление роли в БД
    void save(Role role);

    // Получение конкретной роли (с его пользователями) из БД
    User findById(int id);

    // Получение списка ролей из БД (без пользователей)
    List<Role> findAll();

    // Редактирование существующей роли в БД
    void update(Role role);

    // Удаление роли в БД
    void delete(Role role);
}
