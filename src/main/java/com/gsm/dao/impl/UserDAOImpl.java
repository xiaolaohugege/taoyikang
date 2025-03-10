package com.gsm.dao.impl;

import com.gsm.bean.User;
import com.gsm.dao.inter.UserDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAOImpl implements UserDAO {

    @Override
    public void register(User user) throws Exception {
        String sql = "INSERT INTO Users (UserName, PasswordHash, Email, VerificationCode, CodeExpiration) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, user.getUserName());
            stmt.setString(2, user.getPasswordHash());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getVerificationCode());
            stmt.setTimestamp(5, new java.sql.Timestamp(user.getCodeExpiration().getTime()));
            stmt.executeUpdate();
        }
    }

    @Override
    public User loginByUsername(String username, String password) throws Exception {
        String sql = "SELECT * FROM Users WHERE UserName = ? AND PasswordHash = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            stmt.setString(2, password); // 注意：实际项目中应对密码进行哈希处理
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return extractUser(rs);
            }
        }
        return null;
    }

    @Override
    public User loginByEmail(String email, String password) throws Exception {
        String sql = "SELECT * FROM Users WHERE Email = ? AND PasswordHash = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, email);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return extractUser(rs);
            }
        }
        return null;
    }

    @Override
    public User getUserByEmail(String email) throws Exception {
        String sql = "SELECT * FROM Users WHERE Email = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return extractUser(rs);
            }
        }
        return null;
    }

    @Override
    public void updateUser(User user) throws Exception {
        String sql = "UPDATE Users SET UserName = ?, PasswordHash = ?, Email = ?, VerificationCode = ?, CodeExpiration = ? WHERE UserID = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, user.getUserName());
            stmt.setString(2, user.getPasswordHash());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getVerificationCode());
            stmt.setTimestamp(5, new java.sql.Timestamp(user.getCodeExpiration().getTime()));
            stmt.setInt(6, user.getUserID());
            stmt.executeUpdate();
        }
    }

    private User extractUser(ResultSet rs) throws Exception {
        User user = new User();
        user.setUserID(rs.getInt("UserID"));
        user.setUserName(rs.getString("UserName"));
        user.setPasswordHash(rs.getString("PasswordHash"));
        user.setEmail(rs.getString("Email"));
        user.setVerificationCode(rs.getString("VerificationCode"));
        user.setCodeExpiration(rs.getTimestamp("CodeExpiration"));
        return user;
    }
}
