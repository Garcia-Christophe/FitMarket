package com.m2.tiila.fitmarket.mapper;

import com.m2.tiila.fitmarket.entity.CommentEntity;
import com.m2.tiila.fitmarket.entity.OrderEntity;
import dto.fitmarketapi.Comment;
import dto.fitmarketapi.Order;

public class OrderMapper {
    public static Order toDto(OrderEntity entity) {
        Order dto = new Order();
        dto.setId(entity.getId());
        dto.setUser(entity.getUser());
        dto.setDateOrder(entity.getDateOrder());
        dto.setProducts(entity.getProducts());
        return dto;
    }

    public static OrderEntity toEntity(Order dto) {
        OrderEntity entity = new OrderEntity();
        entity.setId(dto.getId());
        entity.setUser(dto.getUser());
        entity.setDateOrder(dto.getDateOrder());
        entity.setProducts(dto.getProducts());
        return entity;
    }
}
