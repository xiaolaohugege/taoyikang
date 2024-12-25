package com.gsm.view.servlet;

import com.gsm.bean.Users;
import com.gsm.service.impl.UsersServiceImpl;
import com.gsm.service.inter.IUsersService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 *  一个普通的java类 不可能被浏览器 url 能够访的到！！！ 必须是特殊的java类
 *
 */
public class UsersAddServlet extends HttpServlet {

    IUsersService usersService = new UsersServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       this.doPost(req ,  resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String passwordHash = req.getParameter("password_hash");
        String email = req.getParameter("email");

        Users users = new Users();
        users.setUsername(username);
        users.setPasswordHash(passwordHash);
        users.setEmail(email);

        usersService.add(users);

        // 最左侧的/代表的是webapp文件夹
        // c controller 把v view 给到客户端
        req.getRequestDispatcher("/UsersServlet").forward(req ,resp);
//        req.getRequestDispatcher("/user/graduatesList.jsp").forward(req ,resp);

    }
}
