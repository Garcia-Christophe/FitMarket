package com.m2.tiila.fitmarket.mapper;

import com.m2.tiila.fitmarket.entity.ProductEntity;
import dto.fitmarketapi.Category;
import dto.fitmarketapi.Product;

public class ProductMapper {
    public static Product toDto(ProductEntity entity) {

        System.out.println("dto");
        Product dto = new Product();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setDescription(entity.getDescription());
        dto.setCategory(Category.fromValue(entity.getCategory()));
        dto.setImages(entity.getImages());
        dto.setPrice(entity.getPrice());

        return dto;
    }

    public static ProductEntity toEntity(Product dto) {
        System.out.println("entity");
        ProductEntity entity = new ProductEntity();
        entity.setId(dto.getId());
        entity.setTitle(dto.getTitle());
        entity.setDescription(dto.getDescription());
        entity.setCategory(dto.getCategory().toString());
        entity.setImages(dto.getImages());
        entity.setPrice(dto.getPrice());

        return entity;
    }
}
