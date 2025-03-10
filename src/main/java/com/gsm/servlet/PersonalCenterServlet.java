package com.gsm.servlet;

import com.gsm.bean.User;
import com.gsm.service.inter.UserService;
import com.gsm.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

//@WebServlet("/personalCenter")
public class PersonalCenterServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 显示个人信息
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        request.setAttribute("user", user);
        request.getRequestDispatcher("/jsp/personalCenter.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 处理个人信息更新
        String action = request.getParameter("action");
        if ("updateAvatar".equals(action)) {
            // 处理头像更新
            // 需要处理文件上传，此处省略
        } else if ("updatePassword".equals(action)) {
            // 处理密码修改
            String oldPassword = request.getParameter("oldPassword");
            String newPassword = request.getParameter("newPassword");
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            if (user.getPasswordHash().equals(oldPassword)) {
                user.setPasswordHash(newPassword);
                try {
                    userService.updateUser(user);
                    session.setAttribute("user", user);
                    request.setAttribute("message", "密码更新成功");
                } catch (Exception e) {
                    e.printStackTrace();
                    request.setAttribute("error", "密码更新失败");
                }
            } else {
                request.setAttribute("error", "旧密码不正确");
            }
        }
        doGet(request, response);
    }
}
