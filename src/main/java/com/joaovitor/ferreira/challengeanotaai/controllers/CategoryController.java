package com.joaovitor.ferreira.challengeanotaai.controllers;

import com.joaovitor.ferreira.challengeanotaai.domain.category.Category;
import com.joaovitor.ferreira.challengeanotaai.domain.category.CategoryDTO;
import com.joaovitor.ferreira.challengeanotaai.services.CategoryServices;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")

public class CategoryController {

    private CategoryServices service;

    public CategoryController(CategoryServices service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Category>> getCategories(){
        List<Category> allCategories = this.service.getAll();
        return ResponseEntity.ok().body(allCategories);
    }

    @PostMapping
    public ResponseEntity<Category> insert(@RequestBody CategoryDTO categoryData){
        Category returnCategory = this.service.insertCategory(categoryData);
        return ResponseEntity.ok().body(returnCategory);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> update(@PathVariable String id, @RequestBody CategoryDTO categoryData){
        Category updatedCategory = this.service.UpdateCategory(categoryData, id);
        return ResponseEntity.ok().body(updatedCategory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Category> delete(@PathVariable String id){
        Category deletedCategory = this.service.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}
