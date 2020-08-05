package com.qf.service.impl;

import com.qf.dao.UserDao;
import com.qf.pojo.User;
import com.qf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

@Autowired
private UserDao userDao;
    @Override
    public User selectUserByEmailAndPassword(User user) {
        return userDao.selectUserByEmailAndPassword(user);
    }

    @Override
    public Boolean insertUser(User user) {
        return userDao.insertUser(user);
    }

    @Override
    public User selcetByEmail(String email) {
        return userDao.selectUserByEmail(email);
    }

    @Override
    public Boolean updateUser(User user) {
        return userDao.updateUser(user);
    }
}
