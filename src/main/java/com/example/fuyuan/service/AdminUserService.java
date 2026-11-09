package com.example.fuyuan.service;

import com.example.fuyuan.entity.AdminUser;

public interface AdminUserService {
    AdminUser findByUsername(String username);
    boolean login(String username, String password);
}
