package com.example.fuyuan.service.impl;

import com.example.fuyuan.entity.Pet;
import com.example.fuyuan.mapper.PetMapper;
import com.example.fuyuan.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetServiceImpl implements PetService {

    @Autowired
    private PetMapper petMapper;

    @Override
    public List<Pet> findAll() {
        return petMapper.findAll();
    }

    @Override
    public Pet findById(Long id) {
        return petMapper.findById(id);
    }

    @Override
    public void insert(Pet pet) {
        petMapper.insert(pet);
    }

    @Override
    public void update(Pet pet) {
        petMapper.update(pet);
    }

    @Override
    public void deleteById(Long id) {
        petMapper.deleteById(id);
    }
}