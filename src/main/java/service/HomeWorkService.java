package service;

import model.Role;
import model.User;

import java.util.List;

public interface HomeWorkService {
    List<User> readAll();

    List<Role> getUserRoles(User user);

    List<User> getRoleUsers(Role role);

    void deleteById(User user);

    void createUser(User user);

    void updateById(User user);

}
