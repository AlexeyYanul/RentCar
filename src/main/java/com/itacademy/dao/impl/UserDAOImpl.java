package com.itacademy.dao.impl;

import com.itacademy.dao.UserDAO;
import com.itacademy.model.User;
import com.itacademy.utils.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.TypedQuery;

public class UserDAOImpl extends GenericDAOImpl<User, Long> implements UserDAO{

    private static UserDAOImpl instance;

    UserDAOImpl() {
        super(User.class);
    }

    synchronized public static UserDAOImpl getInstance(){
        if (instance == null){
            instance = new UserDAOImpl();
        }
        return instance;
    }

    @Override
    public User findByLoginAndPassword(String login, String password) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM User u WHERE u.login = :login and u.password = :password";
            TypedQuery<User> query = session.createQuery(hql, User.class);
            query.setParameter("login", login);
            query.setParameter("password", password);
            return query.getSingleResult();
        }
    }
}
