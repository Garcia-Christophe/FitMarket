package com.m2.tiila.fitmarket.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import dto.fitmarketapi.Member;
import dto.fitmarketapi.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CommentEntity {
    private Integer id = null;
    private String content = null;
    private String dateTime = null;
    private List<String> images = null;
    private Integer note = null;
    private Product product = null;
    private Member user = null;
    private String title = null;
}
