package com.gsm.dao.inter;

import com.gsm.bean.Users;

import java.util.List;

public interface IUsersDAO {

    void add(Users users);
    void delete(int id);
    void update(Users users);

    Users load(int id);

    Users load(String username);

    List<Users> list();

}
