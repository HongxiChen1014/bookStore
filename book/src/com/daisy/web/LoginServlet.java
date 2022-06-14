package com.daisy.web;

import com.daisy.pojo.User;
import com.daisy.service.UserService;
import com.daisy.service.impl.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class LoginServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        // 2. 调用XxxService.xxx()处理业务
        User loginUser = userService.login(new User(null, username, password, null));
        // 3. 根据login()方法返回结果判断登录是否成功
        if(loginUser == null) {
            req.getRequestDispatcher("/pages/user/login.html").forward(req, resp);
        } else {
            req.getRequestDispatcher("/pages/user/login_success.html").forward(req, resp);
        }
    }
}
