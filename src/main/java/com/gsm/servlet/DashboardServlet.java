// src/main/java/com/gsm/servlet/DashboardServlet.java
package com.gsm.servlet;

import com.gsm.bean.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 1. 获取当前用户（从 Session 中）
        HttpSession session = request.getSession(false); // 不创建新 Session
        User user = (User) session.getAttribute("user");

        if (user == null) {
            // 用户未登录，重定向到登录页面
            response.sendRedirect("login.jsp");
            return;
        }

        // 2. 可以在这里设置一些与仪表盘相关的数据（如果有的话）
        // 例如，用户参与的活动数量、中奖次数等

        // 3. 转发到 dashboard.jsp
        request.getRequestDispatcher("jsp/dashboard.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 通常，仪表盘页面不需要处理 POST 请求，但可以将 POST 请求重定向到 doGet
        doGet(request, response);
    }
}
