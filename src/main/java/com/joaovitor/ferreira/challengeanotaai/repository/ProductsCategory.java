package com.joaovitor.ferreira.challengeanotaai.repository;

import com.joaovitor.ferreira.challengeanotaai.domain.product.Products;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductsCategory extends MongoRepository<Products, String> {
}
