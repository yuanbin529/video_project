package com.qf.dao;

import com.qf.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    User selectUserByEmailAndPassword(User user);

    Boolean insertUser(User user);

    User selectUserByEmail(String email);

    Boolean updateUser(User user);
}
