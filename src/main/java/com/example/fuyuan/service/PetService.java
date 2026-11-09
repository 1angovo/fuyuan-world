package com.example.fuyuan.service;

import com.example.fuyuan.entity.Pet;
import java.util.List;

public interface PetService {
    List<Pet> findAll();
    Pet findById(Long id);
    void insert(Pet pet);
    void update(Pet pet);
    void deleteById(Long id);
}