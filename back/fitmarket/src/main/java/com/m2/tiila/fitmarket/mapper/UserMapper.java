package com.m2.tiila.fitmarket.mapper;

import com.m2.tiila.fitmarket.entity.ClasseEntity;
import com.m2.tiila.fitmarket.entity.MemberEntity;
import dto.fitmarketapi.Classes;
import dto.fitmarketapi.Member;

public class UserMapper {
    public static Member toDto(MemberEntity entity) {
        Member dto = new Member();
        dto.setId(entity.getId());
        dto.setEmail(entity.getEmail());
        dto.setFirstname(entity.getFirstname());
        dto.setLastname(entity.getLastname());
        dto.setPassword(entity.getPassword());
        return dto;
    }

    public static MemberEntity toEntity(Member dto) {
        MemberEntity entity = new MemberEntity();
        entity.setId(dto.getId());
        entity.setEmail(dto.getEmail());
        entity.setFirstname(dto.getFirstname());
        entity.setLastname(dto.getLastname());
        entity.setPassword(dto.getPassword());
        return entity;
    }
}
