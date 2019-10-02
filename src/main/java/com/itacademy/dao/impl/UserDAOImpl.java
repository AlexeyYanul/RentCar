package com.itacademy.dao.impl;

import com.itacademy.dao.UserDAO;
import com.itacademy.model.User;

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
}
