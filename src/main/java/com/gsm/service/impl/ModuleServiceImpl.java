package com.gsm.service.impl;

import com.gsm.bean.Module;
import com.gsm.dao.impl.ModuleDAOImpl;
import com.gsm.dao.inter.ModuleDAO;
import com.gsm.service.inter.ModuleService;
import java.util.List;

public class ModuleServiceImpl implements ModuleService {
    private ModuleDAO moduleDAO = new ModuleDAOImpl();

    @Override
    public List<Module> getAllModules() throws Exception {
        return moduleDAO.getAllModules();
    }

    @Override
    public Module getModuleById(int moduleID) throws Exception {
        return moduleDAO.getModuleById(moduleID);
    }

    @Override
    public List<Module> searchModules(String keyword) throws Exception {
        return moduleDAO.searchModules(keyword);
    }
}
