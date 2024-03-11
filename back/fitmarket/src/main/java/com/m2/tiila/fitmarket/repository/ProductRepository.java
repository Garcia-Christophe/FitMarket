package com.m2.tiila.fitmarket.repository;

import com.m2.tiila.fitmarket.entity.ProductEntity;
import com.m2.tiila.fitmarket.mapper.ProductMapper;
import dto.fitmarketapi.Product;
import jakarta.inject.Inject;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class ProductRepository {

    private final static String SQL_GET_ALL_PRODUCT = "SELECT p.id, p.price, p.description, UPPER(p.category) as category, p.title, GROUP_CONCAT(ip.image) as images " +
            "FROM product p " +
            "LEFT JOIN image_product ip ON p.id = ip.id_product " +
            "GROUP BY p.id";

    private final static String SQL_GET_PRODUCT = "SELECT p.id, p.price, p.description, UPPER(p.category) as category, p.title, GROUP_CONCAT(ip.image) as images " +
            "FROM product p " +
            "LEFT JOIN image_product ip ON p.id = ip.id_product " +
            "WHERE p.id=:id " +
            "GROUP BY p.id";

    @Inject
    private NamedParameterJdbcTemplate jdbcTemplate;

    public List<ProductEntity> getProducts() {
        List<Product> products = new ArrayList<Product>(this.jdbcTemplate.query(SQL_GET_ALL_PRODUCT, new BeanPropertyRowMapper<>(Product.class)));
        return products.stream().map(ProductMapper::toEntity).toList();
    }

    public ProductEntity getProduct(int id) {
        var params = new HashMap<String, Object>();
        params.put("id", id);

        List<Product> products = new ArrayList<Product>(this.jdbcTemplate.query(SQL_GET_PRODUCT, params, new BeanPropertyRowMapper<>(Product.class)));
        return products.stream().map(ProductMapper::toEntity).toList().get(0);
    }
}