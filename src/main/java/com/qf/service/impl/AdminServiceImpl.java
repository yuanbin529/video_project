package com.qf.service.impl;

import com.qf.dao.AdminDao;
import com.qf.pojo.Admin;
import com.qf.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
@Autowired
private AdminDao adminDao;
    @Override
    public Admin findByUsername(String username) {
        return  adminDao.findByUsername(username);
    }

    @Override
    public void regist(Admin admin) {
         adminDao.regist(admin);
    }
}
