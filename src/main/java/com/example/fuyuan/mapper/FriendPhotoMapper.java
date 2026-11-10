package com.example.fuyuan.mapper;

import com.example.fuyuan.entity.FriendPhoto;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface FriendPhotoMapper {

    @Select("SELECT * FROM friend_photo WHERE friend_id = #{friendId} ORDER BY taken_at DESC, created_at DESC")
    List<FriendPhoto> findByFriendId(Long friendId);

    @Insert("INSERT INTO friend_photo(friend_id, image_url, caption, taken_at) " +
            "VALUES(#{friendId}, #{imageUrl}, #{caption}, #{takenAt})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(FriendPhoto photo);

    @Delete("DELETE FROM friend_photo WHERE id=#{id}")
    int deleteById(Long id);

    @Delete("DELETE FROM friend_photo WHERE friend_id=#{friendId}")
    int deleteByFriendId(Long friendId);
}
