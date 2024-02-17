package com.m2.tiila.fitmarket.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import dto.fitmarketapi.Order;
import dto.fitmarketapi.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ClasseEntity {
    private Integer id;
    private Product product;
    private String video;
    private String dayTime;
    private Integer duration;
    private String address;
}
