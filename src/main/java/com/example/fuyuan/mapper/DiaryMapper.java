package com.example.fuyuan.mapper;

import com.example.fuyuan.entity.Diary;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DiaryMapper {

    @Select("SELECT * FROM diary ORDER BY event_date DESC")
    List<Diary> findAll();

    @Select("SELECT * FROM diary WHERE pet_id = #{petId} ORDER BY event_date DESC")
    List<Diary> findByPetId(Long petId);

    @Select("SELECT * FROM diary WHERE id = #{id}")
    Diary findById(Long id);

    @Select("SELECT * FROM diary ORDER BY event_date DESC LIMIT #{offset}, #{size}")
    List<Diary> findPage(@Param("offset") int offset, @Param("size") int size);

    @Select("SELECT COUNT(*) FROM diary")
    int count();

    @Insert("INSERT INTO diary(pet_id, title, content, diary_type, event_date) " +
            "VALUES(#{petId}, #{title}, #{content}, #{diaryType}, #{eventDate})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Diary diary);

    @Update("UPDATE diary SET pet_id=#{petId}, title=#{title}, content=#{content}, " +
            "diary_type=#{diaryType}, event_date=#{eventDate} WHERE id=#{id}")
    int update(Diary diary);

    @Delete("DELETE FROM diary WHERE id=#{id}")
    int deleteById(Long id);
}
