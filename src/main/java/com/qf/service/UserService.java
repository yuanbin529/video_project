package com.qf.service;

import com.qf.pojo.User;


public interface UserService {

    User selectUserByEmailAndPassword(User user);

   Boolean insertUser(User user);

    User selcetByEmail(String email);

    Boolean updateUser(User user);
}
