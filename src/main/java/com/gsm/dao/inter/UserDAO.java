package com.gsm.dao.inter;

import com.gsm.bean.User;

public interface UserDAO {
    void register(User user) throws Exception;
    User loginByUsername(String username, String password) throws Exception;
    User loginByEmail(String email, String password) throws Exception;
    User getUserByEmail(String email) throws Exception;
    void updateUser(User user) throws Exception;
    // 其他必要的方法
}
