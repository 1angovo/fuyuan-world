package com.example.fuyuan.mapper;

import com.example.fuyuan.entity.AdminUser;
import org.apache.ibatis.annotations.*;

@Mapper
public interface AdminUserMapper {

    @Select("SELECT * FROM admin_user WHERE username = #{username}")
    AdminUser findByUsername(String username);

    @Select("SELECT * FROM admin_user WHERE id = #{id}")
    AdminUser findById(Long id);

    @Insert("INSERT INTO admin_user(username, password_hash) VALUES(#{username}, #{passwordHash})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(AdminUser adminUser);
}
