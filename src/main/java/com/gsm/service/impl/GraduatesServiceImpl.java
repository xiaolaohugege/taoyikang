package com.gsm.service.impl;

import com.gsm.bean.Colleges;
import com.gsm.bean.Graduate;
import com.gsm.dao.impl.CollegesDAOImpl;
import com.gsm.dao.impl.GraduatesDAOImpl;
import com.gsm.dao.inter.ICollegesDAO;
import com.gsm.dao.inter.IGraduatesDAO;
import com.gsm.service.inter.ICollegesService;
import com.gsm.service.inter.IGraduatesService;

import java.util.List;

public class GraduatesServiceImpl implements IGraduatesService {

    // 业务逻辑层调用dao层，需要持有dao层对象的引用
    IGraduatesDAO graduatesDAO = new GraduatesDAOImpl();

    public void add(Graduate graduate) {
        graduatesDAO.add(graduate);
    }

    public void delete(int id) {
        graduatesDAO.delete(id);
    }

    public void update(Graduate graduate) {
        graduatesDAO.update(graduate);
    }

    public Graduate load(int id) {
        return graduatesDAO.load(id);
    }

    public List<Graduate> list() {
        return graduatesDAO.list();
    }

    public List<Graduate> find(String nameKey){
        return graduatesDAO.query(nameKey);
    }
}
