package com.m2.tiila.fitmarket.mapper;

import com.m2.tiila.fitmarket.entity.ClasseEntity;
import com.m2.tiila.fitmarket.entity.CommentEntity;
import dto.fitmarketapi.Classes;
import dto.fitmarketapi.Comment;

public class CommentMapper {
    public static Comment toDto(CommentEntity entity) {
        Comment dto = new Comment();
        dto.setId(entity.getId());
        dto.setProduct(entity.getProduct());
        dto.setContent(entity.getContent());
        dto.setNote(entity.getNote());
        dto.setImages(entity.getImages());
        dto.setDateTime(entity.getDateTime());
        dto.setUser(entity.getUser());
        dto.setTitle(entity.getTitle());

        return dto;
    }

    public static CommentEntity toEntity(Comment dto) {
        CommentEntity entity = new CommentEntity();
        entity.setId(dto.getId());
        entity.setProduct(dto.getProduct());
        entity.setContent(dto.getContent());
        entity.setNote(dto.getNote());
        entity.setImages(dto.getImages());
        entity.setDateTime(dto.getDateTime());
        entity.setUser(dto.getUser());
        entity.setTitle(dto.getTitle());

        return entity;
    }
}
