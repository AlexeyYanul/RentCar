package com.itacademy.dao;

import com.itacademy.model.User;

public interface UserDAO extends GenericDAO<User, Long> {

    User findByLoginAndPassword(String login, String password);
}
