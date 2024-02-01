package com.joaovitor.ferreira.challengeanotaai.repository;

import com.joaovitor.ferreira.challengeanotaai.domain.category.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepository extends MongoRepository<Category, String> {
}
