package com.example.fuyuan.service.impl;

import com.example.fuyuan.entity.AdminUser;
import com.example.fuyuan.mapper.AdminUserMapper;
import com.example.fuyuan.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;

@Service
public class AdminUserServiceImpl implements AdminUserService {

    @Autowired
    private AdminUserMapper adminUserMapper;

    @Override
    public AdminUser findByUsername(String username) {
        return adminUserMapper.findByUsername(username);
    }

    @Override
    public boolean login(String username, String password) {
        AdminUser user = adminUserMapper.findByUsername(username);
        if (user == null) return false;
        String md5 = md5Hex(password);
        return md5.equals(user.getPasswordHash());
    }

    private String md5Hex(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digest = md.digest(input.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
