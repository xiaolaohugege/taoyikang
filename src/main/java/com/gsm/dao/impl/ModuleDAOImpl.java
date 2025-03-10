package com.gsm.dao.impl;

import com.gsm.bean.Module;
import com.gsm.dao.inter.ModuleDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ModuleDAOImpl implements ModuleDAO {

    @Override
    public List<Module> getAllModules() throws Exception {
        List<Module> modules = new ArrayList<>();
        String sql = "SELECT * FROM Modules";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Module module = new Module();
                module.setModuleID(rs.getInt("ModuleID"));
                module.setModuleName(rs.getString("ModuleName"));
                module.setDescription(rs.getString("Description"));
                module.setPhotoURL(rs.getString("PhotoURL"));
                modules.add(module);
            }
        }
        return modules;
    }

    @Override
    public Module getModuleById(int moduleID) throws Exception {
        String sql = "SELECT * FROM Modules WHERE ModuleID = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, moduleID);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Module module = new Module();
                module.setModuleID(rs.getInt("ModuleID"));
                module.setModuleName(rs.getString("ModuleName"));
                module.setDescription(rs.getString("Description"));
                module.setPhotoURL(rs.getString("PhotoURL"));
                return module;
            }
        }
        return null;
    }

    @Override
    public List<Module> searchModules(String keyword) throws Exception {
        List<Module> modules = new ArrayList<>();
        String sql = "SELECT * FROM Modules WHERE ModuleName LIKE ? OR Description LIKE ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            String searchPattern = "%" + keyword + "%";
            stmt.setString(1, searchPattern);
            stmt.setString(2, searchPattern);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Module module = new Module();
                module.setModuleID(rs.getInt("ModuleID"));
                module.setModuleName(rs.getString("ModuleName"));
                module.setDescription(rs.getString("Description"));
                module.setPhotoURL(rs.getString("PhotoURL"));
                modules.add(module);
            }
        }
        return modules;
    }
}
