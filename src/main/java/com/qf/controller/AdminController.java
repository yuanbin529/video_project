package com.qf.controller;

import com.qf.utils.JsonResult;
import com.qf.pojo.Admin;
import com.qf.service.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin")
public class AdminController {
    @Autowired
    private AdminService adminService;;

    @RequestMapping("login")
    public JsonResult login(String username, String password){
        Admin admin = adminService.findByUsername(username);
        return new JsonResult(1,null);
    }

    @RequestMapping("regist")
    public JsonResult regist(Admin admin) {
        adminService.regist(admin);
        return  new JsonResult(1,null);
    }


}
