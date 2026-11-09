package com.example.fuyuan.controller;

import com.example.fuyuan.common.Result;
import com.example.fuyuan.entity.Pet;
import com.example.fuyuan.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pets")
public class PetController {

    @Autowired
    private PetService petService;

    @GetMapping
    public Result<List<Pet>> list() {
        return Result.ok(petService.findAll());
    }

    @GetMapping("/{id}")
    public Result<Pet> detail(@PathVariable Long id) {
        Pet pet = petService.findById(id);
        return pet != null ? Result.ok(pet) : Result.fail("宠物不存在");
    }

    @PostMapping
    public Result<Void> add(@RequestBody Pet pet) {
        petService.insert(pet);
        return Result.ok(null);
    }

    @PutMapping("/{id}")
    public Result<Void> update(@PathVariable Long id, @RequestBody Pet pet) {
        pet.setId(id);
        petService.update(pet);
        return Result.ok(null);
    }

    @DeleteMapping("/{id}")
    public Result<Void> delete(@PathVariable Long id) {
        petService.deleteById(id);
        return Result.ok(null);
    }
}