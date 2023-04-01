package service.impl;

import hibernate.HibernateSessionFactoryUtil;
import model.Role;
import model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import service.HomeWorkService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HomeWorkServiceImpl implements HomeWorkService {
    final String user1 = "postgres";
    final String password = "password";
    final String url = "jdbc:postgresql://localhost:5432/skypro";
    @Override
    public List<User> readAll() {
        List<User> users = (List<User>)  HibernateSessionFactoryUtil
                .getSessionFactory().openSession().createQuery("From User").list();
        return users;
    }

    @Override
    public List<Role> getUserRoles(User user) {
        List<Role> roleArrayList = new ArrayList<>();


        try (final Connection connection = DriverManager.getConnection(url, user1, password);
             PreparedStatement statement = connection.prepareStatement(
                     "SELECT * FROM user RIGHT JOIN role ON user.role_id=role.role_id")) {

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {

                int roleId = Integer.parseInt(resultSet.getString("role_id"));
                String roleName = resultSet.getString("role_name");
                roleArrayList.add(new Role(roleId, roleName));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return roleArrayList;
    }

    @Override
    public List<User> getRoleUsers(Role role) {


        return null;
    }

    @Override
    public void deleteById(User user) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(user);
            transaction.commit();
        }
    }

    @Override
    public void createUser(User user) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();) {
            Transaction transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        }
    }

    @Override
    public void updateById(User user) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(user);
            transaction.commit();

        }
    }
}
