// src/main/java/com/gsm/servlet/LogoutServlet.java
package com.gsm.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 使 Session 失效
        HttpSession session = request.getSession(false); // 获取当前 Session，不创建新 Session
        if (session != null) {
            session.invalidate();
        }
        // 重定向到登录页面
        response.sendRedirect("login.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
