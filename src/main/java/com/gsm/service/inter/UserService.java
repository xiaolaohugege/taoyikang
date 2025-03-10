package com.gsm.service.inter;

import com.gsm.bean.User;

public interface UserService {
    void register(User user) throws Exception;
    User login(String identifier, String password, String type) throws Exception;
    void updateUser(User user) throws Exception;
    // 其他必要的方法
}
