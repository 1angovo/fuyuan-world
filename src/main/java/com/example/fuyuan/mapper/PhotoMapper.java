package com.example.fuyuan.mapper;

import com.example.fuyuan.entity.Photo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PhotoMapper {

    @Select("SELECT * FROM photo ORDER BY taken_at DESC")
    List<Photo> findAll();

    @Select("SELECT * FROM photo WHERE pet_id = #{petId} ORDER BY taken_at DESC")
    List<Photo> findByPetId(Long petId);

    @Select("SELECT * FROM photo WHERE category = #{category} ORDER BY taken_at DESC")
    List<Photo> findByCategory(String category);

    @Select("SELECT DISTINCT category FROM photo WHERE category IS NOT NULL")
    List<String> findCategories();

    @Select("SELECT * FROM photo WHERE id = #{id}")
    Photo findById(Long id);

    @Insert("INSERT INTO photo(pet_id, diary_id, image_url, caption, category, taken_at) " +
            "VALUES(#{petId}, #{diaryId}, #{imageUrl}, #{caption}, #{category}, #{takenAt})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Photo photo);

    @Update("UPDATE photo SET caption=#{caption}, category=#{category} WHERE id=#{id}")
    int update(Photo photo);

    @Delete("DELETE FROM photo WHERE id=#{id}")
    int deleteById(Long id);
}
