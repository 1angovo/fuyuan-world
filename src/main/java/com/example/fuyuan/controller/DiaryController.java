package com.example.fuyuan.controller;

import com.example.fuyuan.common.Result;
import com.example.fuyuan.entity.Diary;
import com.example.fuyuan.service.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/diaries")
public class DiaryController {

    @Autowired
    private DiaryService diaryService;

    @GetMapping
    public Result<List<Diary>> list(@RequestParam(required = false) Long petId) {
        if (petId != null) {
            return Result.ok(diaryService.findByPetId(petId));
        }
        return Result.ok(diaryService.findAll());
    }

    @GetMapping("/page")
    public Result<Map<String, Object>> page(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size) {
        return Result.ok(diaryService.findPage(page, size));
    }

    @GetMapping("/{id}")
    public Result<Diary> detail(@PathVariable Long id) {
        Diary diary = diaryService.findById(id);
        return diary != null ? Result.ok(diary) : Result.fail("日记不存在");
    }

    @PostMapping
    public Result<Void> add(@RequestBody Diary diary) {
        diaryService.insert(diary);
        return Result.ok(null);
    }

    @PutMapping("/{id}")
    public Result<Void> update(@PathVariable Long id, @RequestBody Diary diary) {
        diary.setId(id);
        diaryService.update(diary);
        return Result.ok(null);
    }

    @DeleteMapping("/{id}")
    public Result<Void> delete(@PathVariable Long id) {
        diaryService.deleteById(id);
        return Result.ok(null);
    }
}
