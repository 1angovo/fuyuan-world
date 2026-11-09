package com.example.fuyuan.controller;

import com.example.fuyuan.common.Result;
import com.example.fuyuan.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminUserService adminUserService;

    @PostMapping("/login")
    public Result<Map<String, Object>> login(@RequestBody Map<String, String> body) {
        String username = body.get("username");
        String password = body.get("password");
        if (username == null || password == null) {
            return Result.fail("用户名或密码不能为空");
        }
        boolean success = adminUserService.login(username, password);
        if (success) {
            Map<String, Object> data = new HashMap<>();
            data.put("username", username);
            data.put("token", "demo-token-" + username);
            return Result.ok(data);
        }
        return Result.fail(401, "用户名或密码错误");
    }
}
