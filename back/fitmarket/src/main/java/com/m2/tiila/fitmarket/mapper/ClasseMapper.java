package com.m2.tiila.fitmarket.mapper;

import com.m2.tiila.fitmarket.entity.ClasseEntity;
import com.m2.tiila.fitmarket.entity.ProductEntity;
import dto.fitmarketapi.Category;
import dto.fitmarketapi.Classes;
import dto.fitmarketapi.Product;

public class ClasseMapper {
    public static Classes toDto(ClasseEntity entity) {
        Classes dto = new Classes();
        dto.setId(entity.getId());
        dto.setAddress(entity.getAddress());
        dto.setDuration(entity.getDuration());
        dto.setDayTime(entity.getDayTime());
        dto.setProduct(entity.getProduct());
        dto.setVideo(entity.getVideo());

        return dto;
    }

    public static ClasseEntity toEntity(Classes dto) {
        ClasseEntity entity = new ClasseEntity();
        entity.setId(dto.getId());
        entity.setAddress(dto.getAddress());
        entity.setDuration(dto.getDuration());
        entity.setDayTime(dto.getDayTime());
        entity.setProduct(dto.getProduct());
        entity.setVideo(dto.getVideo());

        return entity;
    }
}
