package com.m2.tiila.fitmarket.repository;

import com.m2.tiila.fitmarket.entity.ClasseEntity;
import com.m2.tiila.fitmarket.mapper.ClasseMapper;
import com.m2.tiila.fitmarket.mapper.OrderMapper;
import dto.fitmarketapi.Category;
import dto.fitmarketapi.Classes;
import dto.fitmarketapi.Product;
import jakarta.inject.Inject;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.m2.tiila.fitmarket.mapper.ClasseMapper.toEntity;

@Component
public class ClasseRepository {
    private final static String SQL_GET_ALL_CLASSES_BY_USER_ID = "SELECT cl.id AS class_id, cl.video, cl.day_time, cl.duration, cl.address, " +
            "p.id AS product_id, p.title AS product_title, p.price AS product_price, " +
            "p.description AS product_description, p.category AS product_category " +
            "FROM classes cl " +
            "LEFT JOIN product p ON p.id = cl.id_product " +
            "LEFT JOIN order_product op ON op.id_product = p.id " +
            "LEFT JOIN orders o ON o.id = op.id_order " +
            "WHERE o.id_user = :userId AND o.date_order IS NOT NULL";

    private final static String SQL_GET_CLASSE =  "SELECT c.id, c.video, c.day_time, c.duration, c.address, " +
            "p.id AS product_id, p.title AS product_title, p.price AS product_price, " +
            "p.description AS product_description, p.category AS product_category " +
            "FROM classes c " +
            "JOIN product p ON c.id_product = p.id " +
            "WHERE c.id = :classesId";

    @Inject
    private NamedParameterJdbcTemplate jdbcTemplate;


    public List<ClasseEntity> getClassesByUserId(Integer userId) {
        MapSqlParameterSource params = new MapSqlParameterSource().addValue("userId", userId);

        List<Classes> classesUserId = jdbcTemplate.query(SQL_GET_ALL_CLASSES_BY_USER_ID, params, (resultSet, rowNum) -> {
            Classes classes = new Classes();
            classes.setId(resultSet.getInt("class_id"));
            classes.setVideo(resultSet.getString("video"));
            classes.setDayTime(resultSet.getString("day_time"));
            classes.setDuration(resultSet.getInt("duration"));
            classes.setAddress(resultSet.getString("address"));

            Product product = new Product();
            product.setId(resultSet.getInt("product_id"));
            product.setTitle(resultSet.getString("product_title"));
            product.setPrice(resultSet.getInt("product_price"));
            product.setDescription(resultSet.getString("product_description"));
            product.setCategory(Category.fromValue(resultSet.getString("product_category")));

            classes.setProduct(product);

            return classes;
        });
        return classesUserId.stream().map(ClasseMapper::toEntity).toList();
    }

    public ClasseEntity getClasse(int id) {
        MapSqlParameterSource params = new MapSqlParameterSource().addValue("classesId", id);

        return toEntity(jdbcTemplate.queryForObject(SQL_GET_CLASSE, params, (resultSet, rowNum) -> {
            Classes classes = new Classes();
            classes.setId(resultSet.getInt("id"));
            classes.setVideo(resultSet.getString("video"));
            classes.setDayTime(resultSet.getString("day_time"));
            classes.setDuration(resultSet.getInt("duration"));
            classes.setAddress(resultSet.getString("address"));

            Product product = new Product();
            product.setId(resultSet.getInt("product_id"));
            product.setTitle(resultSet.getString("product_title"));
            product.setPrice(resultSet.getInt("product_price"));
            product.setDescription(resultSet.getString("product_description"));
            product.setCategory(Category.fromValue(resultSet.getString("product_category")));

            classes.setProduct(product);

            return classes;
        }));
    }

}