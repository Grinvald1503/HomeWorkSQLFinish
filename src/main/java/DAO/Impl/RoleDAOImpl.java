package DAO.Impl;

import DAO.RoleDAO;
import hibernate.HibernateSessionFactoryUtil;
import model.Role;
import model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class RoleDAOImpl implements RoleDAO {
    @Override
    public void save(Role role) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();) {
            Transaction transaction = session.beginTransaction();
            session.save(role);
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
    public List<Role> findAll() {
        List<Role> roles = (List<Role>) HibernateSessionFactoryUtil
                .getSessionFactory().openSession().createSQLQuery("select * from roles").list();
        return roles;
    }

    @Override
    public void update(Role role) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(role);
            transaction.commit();
        }

    }

    @Override
    public void delete(Role role) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(role);
            transaction.commit();
        }

    }
}
