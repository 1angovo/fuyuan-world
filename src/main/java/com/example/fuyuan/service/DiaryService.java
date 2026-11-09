package com.example.fuyuan.service;

import com.example.fuyuan.entity.Diary;
import java.util.List;
import java.util.Map;

public interface DiaryService {
    List<Diary> findAll();
    List<Diary> findByPetId(Long petId);
    Diary findById(Long id);
    Map<String, Object> findPage(int page, int size);
    void insert(Diary diary);
    void update(Diary diary);
    void deleteById(Long id);
}
