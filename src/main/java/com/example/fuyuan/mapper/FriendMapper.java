package com.example.fuyuan.mapper;

import com.example.fuyuan.entity.Friend;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface FriendMapper {

    @Select("SELECT * FROM friend ORDER BY created_at DESC")
    List<Friend> findAll();

    @Select("SELECT * FROM friend WHERE id = #{id}")
    Friend findById(Long id);

    @Insert("INSERT INTO friend(name, species, breed, gender, birthday, personality, description, avatar_url) " +
            "VALUES(#{name}, #{species}, #{breed}, #{gender}, #{birthday}, #{personality}, #{description}, #{avatarUrl})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Friend friend);

    @Update("UPDATE friend SET name=#{name}, species=#{species}, breed=#{breed}, gender=#{gender}, " +
            "birthday=#{birthday}, personality=#{personality}, description=#{description}, avatar_url=#{avatarUrl} WHERE id=#{id}")
    int update(Friend friend);

    @Delete("DELETE FROM friend WHERE id=#{id}")
    int deleteById(Long id);
}
