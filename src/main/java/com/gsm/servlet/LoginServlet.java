// src/main/java/com/gsm/servlet/LoginServlet.java
package com.gsm.servlet;

import com.gsm.bean.User;
import com.gsm.service.inter.UserService;
import com.gsm.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

//@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String identifier = request.getParameter("identifier"); // 用户名或邮箱
        String password = request.getParameter("password");
        String loginType = request.getParameter("loginType"); // "username" 或 "email"

        if (identifier == null || password == null || loginType == null ||
                identifier.isEmpty() || password.isEmpty() || loginType.isEmpty()) {
            request.setAttribute("error", "所有字段均为必填项");
            request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
            return;
        }

        try {
            User user = userService.login(identifier, password, loginType);
            if (user != null) {
                // 登录成功，设置Session
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                // 重定向到仪表盘
                response.sendRedirect("dashboard");
            } else {
                request.setAttribute("error", "用户名/邮箱或密码错误");
                request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "登录失败");
            request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
