package com.gsm.service.inter;

import com.gsm.bean.Colleges;

import java.util.List;

/**
 *  业务逻辑层往往会调用dao层，但是不仅仅是调用dao层
 *      比如注册方法其中会调用dao层的add方法往数据库插入数据 但是还
 *      可能有一些业务操作 比如和邮箱发确认邮件...
 *
 *  大家记住: 业务逻辑层方法是有对错的，但是dao层就是执行数据库操作 没有对错
 */
public interface ICollegesService {

    void add(Colleges colleges);
    void delete(int id);
    void update(Colleges colleges);

    Colleges load(int id);

    List<Colleges> list();

    List<Colleges> find(String nameKey);

}
