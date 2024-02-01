package com.joaovitor.ferreira.challengeanotaai.domain.product;

import com.joaovitor.ferreira.challengeanotaai.domain.category.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;
@Document()
@Getter
@Setter
@NoArgsConstructor
public class Products {
    @Id
    private String id;
    private String title;
    private String description;
    private BigInteger price;
    private Category category;
    private String ownerId;

}
