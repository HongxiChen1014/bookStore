package com.daisy.web;


import com.daisy.pojo.User;
import com.daisy.service.UserService;
import com.daisy.service.impl.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class RegistServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");
        // 2. 检查验证码是否正确
        if("abcde".equalsIgnoreCase(code)) {
            // 3. 检查用户名是否可用
            if(userService.existUsername(username)) {
                req.getRequestDispatcher("/pages/user/regist.html").forward(req,resp);
            } else {
                userService.registerUser(new User(null,username,password,email));
                // 跳转到regist_success.html
                req.getRequestDispatcher("/pages/user/regist_success.html").forward(req,resp);
            }
        } else {
            System.out.println("invalid code");
            req.getRequestDispatcher("/pages/user/regist.html").forward(req,resp);
        }
    }
}
