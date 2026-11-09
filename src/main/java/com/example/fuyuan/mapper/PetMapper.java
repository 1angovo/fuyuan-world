package com.example.fuyuan.mapper;

import com.example.fuyuan.entity.Pet;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PetMapper {

    @Select("SELECT * FROM pet ORDER BY created_at DESC")
    List<Pet> findAll();

    @Select("SELECT * FROM pet WHERE id = #{id}")
    Pet findById(Long id);

    @Insert("INSERT INTO pet(name, breed, gender, birthday, arrival_date, personality, hobbies, description, avatar_url) " +
            "VALUES(#{name}, #{breed}, #{gender}, #{birthday}, #{arrivalDate}, #{personality}, #{hobbies}, #{description}, #{avatarUrl})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Pet pet);

    @Update("UPDATE pet SET name=#{name}, breed=#{breed}, gender=#{gender}, birthday=#{birthday}, " +
            "arrival_date=#{arrivalDate}, personality=#{personality}, hobbies=#{hobbies}, " +
            "description=#{description}, avatar_url=#{avatarUrl} WHERE id=#{id}")
    int update(Pet pet);

    @Delete("DELETE FROM pet WHERE id=#{id}")
    int deleteById(Long id);
}
