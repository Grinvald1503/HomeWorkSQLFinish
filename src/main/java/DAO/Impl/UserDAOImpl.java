package DAO.Impl;

import DAO.UserDAO;
import hibernate.HibernateSessionFactoryUtil;
import model.Role;
import model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class UserDAOImpl implements UserDAO {
    @Override
    public void create(User user) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();) {
            Transaction transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        }

    }

    @Override
    public User findById(int id) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            return session.get(User.class, id);
        }
    }

    @Override
    public List<User> findUserByRole(String setParameterQueryRole) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            String hql = "FROM User u LEFT JOIN FETCH u.roles role WHERE role = :rolename";
            Query<User> query = session.createQuery(hql, User.class);
            query.setParameter("rolename", setParameterQueryRole);
            List<User> resultListUser = query.getResultList();

            return resultListUser;
        }
    }

    @Override
    public List<Role> findRoleByUser(String setParameterQueryUser) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            String hql = "FROM Role r LEFT JOIN FETCH r.users user WHERE user.name = :username";
            Query<Role> query = session.createQuery(hql, Role.class);
            query.setParameter("username", setParameterQueryUser);
            List<Role> resultListRole = query.getResultList();

            return resultListRole;
        }
    }

    @Override
    public List<User> findAll() {

        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM User").list();
        }
    }

    @Override
    public void update(User user) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(user);
            transaction.commit();
        }

    }

    @Override
    public void delete(User user) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(user);
            transaction.commit();
        }

    }
}
