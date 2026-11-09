package com.example.fuyuan.service.impl;

import com.example.fuyuan.entity.Photo;
import com.example.fuyuan.mapper.PhotoMapper;
import com.example.fuyuan.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhotoServiceImpl implements PhotoService {

    @Autowired
    private PhotoMapper photoMapper;

    @Override
    public List<Photo> findAll() {
        return photoMapper.findAll();
    }

    @Override
    public List<Photo> findByPetId(Long petId) {
        return photoMapper.findByPetId(petId);
    }

    @Override
    public List<Photo> findByCategory(String category) {
        return photoMapper.findByCategory(category);
    }

    @Override
    public List<String> findCategories() {
        return photoMapper.findCategories();
    }

    @Override
    public Photo findById(Long id) {
        return photoMapper.findById(id);
    }

    @Override
    public void insert(Photo photo) {
        photoMapper.insert(photo);
    }

    @Override
    public void update(Photo photo) {
        photoMapper.update(photo);
    }

    @Override
    public void deleteById(Long id) {
        photoMapper.deleteById(id);
    }
}
