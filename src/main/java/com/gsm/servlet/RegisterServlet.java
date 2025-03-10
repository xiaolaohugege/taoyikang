package com.gsm.servlet;

import com.gsm.bean.User;
import com.gsm.service.inter.UserService;
import com.gsm.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Date;

//@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取表单参数
        String username = request.getParameter("username");
        String password = request.getParameter("password"); // 需要哈希处理
        String email = request.getParameter("email");

        // 简单的参数验证
        if (username == null || password == null || email == null ||
                username.isEmpty() || password.isEmpty() || email.isEmpty()) {
            request.setAttribute("error", "所有字段均为必填项");
            request.getRequestDispatcher("/jsp/register.jsp").forward(request, response);
            return;
        }

        // 创建User对象
        User user = new User();
        user.setUserName(username);
        user.setPasswordHash(password); // 实际项目中应进行哈希
        user.setEmail(email);
        // 生成验证码和设置过期时间
        user.setVerificationCode("123456"); // 应生成随机验证码
        user.setCodeExpiration(new Date(System.currentTimeMillis() + 24*60*60*1000)); // 24小时有效

        try {
            userService.register(user);
            // 发送验证邮件的逻辑
            // ...

            response.sendRedirect("login");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "注册失败，可能用户名或邮箱已存在");
            request.getRequestDispatcher("/jsp/register.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
