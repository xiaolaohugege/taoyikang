package com.gsm.service.inter;

import com.gsm.bean.Module;
import java.util.List;

public interface ModuleService {
    List<Module> getAllModules() throws Exception;
    Module getModuleById(int moduleID) throws Exception;
    List<Module> searchModules(String keyword) throws Exception;
}
