package com.gsm.service.impl;

import com.gsm.bean.Users;
import com.gsm.dao.impl.UsersDAOImpl;
import com.gsm.dao.inter.IUsersDAO;
import com.gsm.exception.JobException;
import com.gsm.service.inter.IUsersService;

import java.util.List;

public class UsersServiceImpl implements IUsersService {

    // 业务逻辑层调用dao层，需要持有dao层对象的引用
    IUsersDAO usersDAO = new UsersDAOImpl();

    public void add(Users users) {
        usersDAO.add(users);
    }

    public void delete(int id) {
        usersDAO.delete(id);
    }

    public void update(Users users) {
        usersDAO.update(users);
    }

    public Users load(int id) {
        return usersDAO.load(id);
    }

    public List<Users> list() {
        return usersDAO.list();
    }

    public Users login(String username, String passwordHash) {

        Users users = usersDAO.load(username);

        if(users == null)
        {
            throw new JobException("用户名不存在!");
        }

        if(! users.getPasswordHash().equals(passwordHash))
        {
            throw new JobException("密码不正确!");
        }


        return users;
    }
}
