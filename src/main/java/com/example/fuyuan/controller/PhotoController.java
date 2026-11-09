package com.example.fuyuan.controller;

import com.example.fuyuan.common.Result;
import com.example.fuyuan.entity.Photo;
import com.example.fuyuan.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/photos")
public class PhotoController {

    @Autowired
    private PhotoService photoService;

    @Value("${upload.path:./uploads/}")
    private String uploadPath;

    @GetMapping
    public Result<List<Photo>> list(
            @RequestParam(required = false) Long petId,
            @RequestParam(required = false) String category) {
        if (category != null && !category.isEmpty()) {
            return Result.ok(photoService.findByCategory(category));
        }
        if (petId != null) {
            return Result.ok(photoService.findByPetId(petId));
        }
        return Result.ok(photoService.findAll());
    }

    @GetMapping("/categories")
    public Result<List<String>> categories() {
        return Result.ok(photoService.findCategories());
    }

    @GetMapping("/{id}")
    public Result<Photo> detail(@PathVariable Long id) {
        Photo photo = photoService.findById(id);
        return photo != null ? Result.ok(photo) : Result.fail("照片不存在");
    }

    @PostMapping("/upload")
    public Result<Map<String, String>> upload(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return Result.fail("请选择文件");
        }
        try {
            File dir = new File(uploadPath);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            String originalName = file.getOriginalFilename();
            String ext = originalName != null && originalName.contains(".")
                    ? originalName.substring(originalName.lastIndexOf(".")) : ".jpg";
            String newName = UUID.randomUUID().toString().replace("-", "") + ext;
            File dest = new File(dir, newName);
            file.transferTo(dest);

            Map<String, String> data = new HashMap<>();
            data.put("url", "/uploads/" + newName);
            data.put("filename", newName);
            return Result.ok(data);
        } catch (IOException e) {
            return Result.fail("上传失败: " + e.getMessage());
        }
    }

    @PostMapping
    public Result<Void> add(@RequestBody Photo photo) {
        photoService.insert(photo);
        return Result.ok(null);
    }

    @PutMapping("/{id}")
    public Result<Void> update(@PathVariable Long id, @RequestBody Photo photo) {
        photo.setId(id);
        photoService.update(photo);
        return Result.ok(null);
    }

    @DeleteMapping("/{id}")
    public Result<Void> delete(@PathVariable Long id) {
        photoService.deleteById(id);
        return Result.ok(null);
    }
}
