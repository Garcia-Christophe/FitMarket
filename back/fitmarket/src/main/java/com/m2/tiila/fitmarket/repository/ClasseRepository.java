package com.m2.tiila.fitmarket.repository;

import com.m2.tiila.fitmarket.entity.ClasseEntity;
import com.m2.tiila.fitmarket.mapper.ClasseMapper;
import dto.fitmarketapi.Classes;
import jakarta.inject.Inject;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class ClasseRepository {
    private final static String SQL_GET_ALL_CLASSES = "SELECT cl.* FROM classes cl ";

    private final static String SQL_GET_ALL_CLASSES_BY_USER_ID = "SELECT cl.* FROM CLASSES cl " +
            "LEFT JOIN product p ON p.id = cl.id_product " +
            "LEFT JOIN order_product op ON op.id_product = p.id " +
            "LEFT JOIN orders o ON o.id = op.id_order " +
            "WHERE o.id_user=:id and o.date_order IS NOT NULL";

    private final static String SQL_GET_CLASSE = "SELECT *  FROM classes cl " +
            "WHERE id=:id";

    private final static String SQL_GET_ID_PRODUIT_BY_CLASSES = "SELECT id_product FROM classes "+
            "WHERE id=:id";

    @Inject
    private NamedParameterJdbcTemplate jdbcTemplate;

    public List<ClasseEntity> getClasses() {
        List<Classes> classes = new ArrayList<Classes>(this.jdbcTemplate.query(SQL_GET_ALL_CLASSES, new BeanPropertyRowMapper<>(Classes.class)));
        return classes.stream().map(ClasseMapper::toEntity).toList();
    }

    public List<ClasseEntity> getClassesByUserId(int id) {
        var params = new HashMap<String, Object>();
        params.put("id", id);

        List<Classes> classes = new ArrayList<Classes>(this.jdbcTemplate.query(SQL_GET_ALL_CLASSES_BY_USER_ID, params,new BeanPropertyRowMapper<>(Classes.class)));
        return classes.stream().map(ClasseMapper::toEntity).toList();
    }

    public ClasseEntity getClasse(int id) {
        var params = new HashMap<String, Object>();
        params.put("id", id);

        List<Classes> classe = new ArrayList<Classes>(this.jdbcTemplate.query(SQL_GET_CLASSE, params, new BeanPropertyRowMapper<>(Classes.class)));
        return classe.stream().map(ClasseMapper::toEntity).toList().get(0);
    }

    public Integer getIdProduct(int id) {
        var params = new HashMap<String, Object>();
        params.put("id", id);

        List<Integer> id_produit = new ArrayList<Integer>(this.jdbcTemplate.queryForList(SQL_GET_ID_PRODUIT_BY_CLASSES, params, Integer.class));

        return id_produit.get(0);
    }
}