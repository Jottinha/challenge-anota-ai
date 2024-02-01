package com.joaovitor.ferreira.challengeanotaai.services;

import com.joaovitor.ferreira.challengeanotaai.domain.category.Category;
import com.joaovitor.ferreira.challengeanotaai.domain.category.CategoryDTO;
import com.joaovitor.ferreira.challengeanotaai.repository.CategoryRepository;
import com.joaovitor.ferreira.challengeanotaai.services.exceptions.CategoryNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServices {
    private CategoryRepository repository;

    public CategoryServices(CategoryRepository repository){
        this.repository = repository;
    }

    public List<Category> getAll(){
        return this.repository.findAll();
    }
    public Category insertCategory(CategoryDTO category){
        return this.repository.save(new Category(category));
    }

    //TODO: Verify if newCategoryData is null
    public Category UpdateCategory(CategoryDTO newCategoryData ,String idCategory){
        Category categoryData = this.repository.findById(idCategory).orElseThrow(CategoryNotFoundException::new);

        if (!newCategoryData.title().isEmpty()){
            categoryData.setTitle(newCategoryData.title());
        }

        if (!newCategoryData.description().isEmpty()){
            categoryData.setDescription(newCategoryData.description());
        }

        if (!newCategoryData.ownerId().isEmpty()){
            categoryData.setOwnerId(newCategoryData.ownerId());
        }

        return this.repository.save(categoryData);
    }

    public Category deleteCategory(String idCategory){

        Category categoryData = this.repository.findById(idCategory).orElseThrow(CategoryNotFoundException::new);
        this.repository.delete(categoryData);

        return categoryData;
    }
}
