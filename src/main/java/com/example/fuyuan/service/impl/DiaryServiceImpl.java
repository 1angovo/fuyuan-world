package com.example.fuyuan.service.impl;

import com.example.fuyuan.entity.Diary;
import com.example.fuyuan.mapper.DiaryMapper;
import com.example.fuyuan.service.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DiaryServiceImpl implements DiaryService {

    @Autowired
    private DiaryMapper diaryMapper;

    @Override
    public List<Diary> findAll() {
        return diaryMapper.findAll();
    }

    @Override
    public List<Diary> findByPetId(Long petId) {
        return diaryMapper.findByPetId(petId);
    }

    @Override
    public Diary findById(Long id) {
        return diaryMapper.findById(id);
    }

    @Override
    public Map<String, Object> findPage(int page, int size) {
        int offset = (page - 1) * size;
        List<Diary> records = diaryMapper.findPage(offset, size);
        int total = diaryMapper.count();
        Map<String, Object> result = new HashMap<>();
        result.put("records", records);
        result.put("total", total);
        result.put("page", page);
        result.put("size", size);
        return result;
    }

    @Override
    public void insert(Diary diary) {
        diaryMapper.insert(diary);
    }

    @Override
    public void update(Diary diary) {
        diaryMapper.update(diary);
    }

    @Override
    public void deleteById(Long id) {
        diaryMapper.deleteById(id);
    }
}
