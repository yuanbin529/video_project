package com.qf.service;

import com.qf.pojo.Admin;


public interface AdminService {
    public Admin findByUsername(String username);

    void regist(Admin admin);
}
