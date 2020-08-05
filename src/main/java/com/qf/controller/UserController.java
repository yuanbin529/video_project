package com.qf.controller;

import com.qf.pojo.User;
import com.qf.service.UserService;

import com.qf.utils.MailUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/loginUser")
    @ResponseBody
    public String loginUser(User user, HttpServletRequest request) {
        user =userService.selectUserByEmailAndPassword(user);
        if (null != user) {
            HttpSession session = request.getSession();
            session.setAttribute("userAccount",user.getEmail());
            return "success";
        }
        return "failed" ;
    }

    @RequestMapping("/loginOut")
    @ResponseBody
    public String LoginOut(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        session.removeAttribute("userAccount");
        return "success";
    }

    @RequestMapping("/validateEmail")
    @ResponseBody
    public String validateEmail (String email) {
        User user =userService.selcetByEmail(email);
        if (user == null) {
            return "success";
        }
        return "hasUser";
    }

    @RequestMapping("/insertUser")
    @ResponseBody
    public String insertUser(User user,HttpServletRequest request) {
        user.setCreateTime(new Date());
            userService.insertUser(user);
            HttpSession session = request.getSession();
            session.setAttribute("userAccount",user.getEmail());
            return "success";
    }

    @RequestMapping("/forgetPassword")
    public String forgetPassword() { return "/jsp/before/forget_password.jsp";}

    @RequestMapping("/sendEmail")
    @ResponseBody
    public String  sendEmail(String email, HttpServletRequest request) {
        if ("success".equals(validateEmail(email))) {
            return  "hasNoUser";
        }

        String code = MailUtils.getValidateCode(6);
            boolean flag  =MailUtils.sendMail(email, "测试邮件随机生成的验证码是：" + code, "你好，这是一封测试邮件，无需回复。");
            if (flag) {
                HttpSession session = request.getSession();
                session.setAttribute("email", email);
                session.setAttribute("code", code);
                return "success";
            }
            return "failed";
    }

    @RequestMapping("/validateEmailCode")
    public String validateEmailCode(String email, String code, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String sessionEmail = (String) session.getAttribute("email");
        String sessionCode = (String) session.getAttribute("code");
        if (sessionEmail.equals(email) && sessionCode.equals(code)) {
            return "/jsp/before/reset_password.jsp";
        }
        return "redirect:/user/forgetPassword.jsp";
    }

    @RequestMapping("/resetPassword")
    public String resetPassword(String email, String password, HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute("email");
        session.removeAttribute("code");
        User user = userService.selcetByEmail(email);
        if (null != user) {
            user.setPassword(password);

            userService.updateUser(user);
            session.setAttribute("userAccount", user.getEmail());
        }
        return "redirect:/";
    }

    @RequestMapping("/showMyProfile")
    public String showMyProfile(HttpServletRequest request)  {
        HttpSession session = request.getSession();
        User user =userService.selcetByEmail((String) session.getAttribute("userAccount"));
        session.setAttribute("user",user);
        return "/jsp/before/my_profile.jsp";
    }

    @RequestMapping("/loginOut2")
    public String loginOut2(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        session.removeAttribute("userAccount");
        return "redirect:/";
    }

    @RequestMapping("/changeProfile")
    public String changeProfile() {
        return "/jsp/before/change_profile.jsp";
    }


    @RequestMapping("/updateUser" )
    public String updateUser(String nickName, String sex, String birthday, String address, HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        user.setNickName(nickName);
        System.out.println(nickName);
        user.setSex(sex);
        user.setBirthday(birthday);
        user.setAddress(address);
        userService.updateUser(user);
        return "redirect:/user/showMyProfile";
    }
}


