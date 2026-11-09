package com.example.fuyuan.service;

import com.example.fuyuan.entity.Photo;
import java.util.List;

public interface PhotoService {
    List<Photo> findAll();
    List<Photo> findByPetId(Long petId);
    List<Photo> findByCategory(String category);
    List<String> findCategories();
    Photo findById(Long id);
    void insert(Photo photo);
    void update(Photo photo);
    void deleteById(Long id);
}
