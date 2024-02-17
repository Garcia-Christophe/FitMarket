package com.m2.tiila.fitmarket.entity;

import dto.fitmarketapi.Order;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductEntity {
    private Integer id;
    private Integer price;
    private List<String> images;
    private String description;
    private String category;
    private String title;
}
