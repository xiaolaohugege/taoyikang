package com.gsm.bean;

import java.util.Date;

public class Users {
    private int userId;
    private String username;
    private String passwordHash;
    private String email;
    private String role;

    private Date createdAt;
    private Date updateedAt;

    //  全部参数构造器
    public Users(int userId, String username, String passwordHash, String email, String role, Date createdAt, Date updateedAt) {
        this.userId = userId;
        this.username = username;
        this.passwordHash = passwordHash;
        this.email = email;
        this.role = role;
        this.createdAt = createdAt;
        this.updateedAt = updateedAt;
    }

    // 去掉主键 所有参数
    public Users(String username, String passwordHash, String email, String role, Date createdAt, Date updateedAt) {
        this.username = username;
        this.passwordHash = passwordHash;
        this.email = email;
        this.role = role;
        this.createdAt = createdAt;
        this.updateedAt = updateedAt;
    }

    public Users() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdateedAt() {
        return updateedAt;
    }

    public void setUpdateedAt(Date updateedAt) {
        this.updateedAt = updateedAt;
    }

    @Override
    public String toString() {
        return "Users{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", passwordHash='" + passwordHash + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", createdAt=" + createdAt +
                ", updateedAt=" + updateedAt +
                '}';
    }
}
