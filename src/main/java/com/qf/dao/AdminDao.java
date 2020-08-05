package com.qf.dao;

import com.qf.pojo.Admin;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminDao {
    public Admin findByUsername(String username);

    void regist(Admin admin);
}
