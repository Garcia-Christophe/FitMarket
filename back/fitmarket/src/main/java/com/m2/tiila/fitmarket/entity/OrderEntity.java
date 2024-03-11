package com.m2.tiila.fitmarket.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import dto.fitmarketapi.Member;
import dto.fitmarketapi.OrderProduct;
import dto.fitmarketapi.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderEntity {
    private Integer id;
    private String dateOrder;
    private Member user;
    private List<OrderProduct> products;
}
