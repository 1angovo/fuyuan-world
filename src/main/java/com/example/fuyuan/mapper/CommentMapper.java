package com.example.fuyuan.mapper;

import com.example.fuyuan.entity.Comment;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CommentMapper {

    @Select("SELECT * FROM comment WHERE status = 0 ORDER BY created_at DESC")
    List<Comment> findPending();

    @Select("SELECT * FROM comment WHERE status = 1 ORDER BY created_at DESC")
    List<Comment> findApproved();

    @Select("SELECT * FROM comment ORDER BY created_at DESC")
    List<Comment> findAll();

    @Select("SELECT * FROM comment WHERE id = #{id}")
    Comment findById(Long id);

    @Select("SELECT COUNT(*) FROM comment")
    int count();

    @Select("SELECT * FROM comment ORDER BY created_at DESC LIMIT #{offset}, #{size}")
    List<Comment> findPage(@Param("offset") int offset, @Param("size") int size);

    @Insert("INSERT INTO comment(nickname, content, status) VALUES(#{nickname}, #{content}, #{status})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Comment comment);

    @Update("UPDATE comment SET status=#{status} WHERE id=#{id}")
    int updateStatus(@Param("id") Long id, @Param("status") int status);

    @Delete("DELETE FROM comment WHERE id=#{id}")
    int deleteById(Long id);
}
