package com.gsm.dao.inter;

import com.gsm.bean.Module;
import java.util.List;

public interface ModuleDAO {
    List<Module> getAllModules() throws Exception;
    Module getModuleById(int moduleID) throws Exception;
    List<Module> searchModules(String keyword) throws Exception;
    // 其他必要的方法
}
