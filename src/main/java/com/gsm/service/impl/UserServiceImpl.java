package com.gsm.service.impl;

import com.gsm.bean.User;
import com.gsm.dao.inter.UserDAO;
import com.gsm.dao.impl.UserDAOImpl;
import com.gsm.service.inter.UserService;

public class UserServiceImpl implements UserService {
    private UserDAO userDAO = new UserDAOImpl();

    @Override
    public void register(User user) throws Exception {
        // 可以添加更多的业务逻辑，如验证用户名和邮箱唯一性，发送验证邮件等
        userDAO.register(user);
    }

    @Override
    public User login(String identifier, String password, String type) throws Exception {
        if ("username".equals(type)) {
            return userDAO.loginByUsername(identifier, password);
        } else if ("email".equals(type)) {
            return userDAO.loginByEmail(identifier, password);
        }
        return null;
    }

    @Override
    public void updateUser(User user) throws Exception {
        userDAO.updateUser(user);
    }
}
