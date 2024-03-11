package com.m2.tiila.fitmarket.repository;

import com.m2.tiila.fitmarket.entity.CommentEntity;
import com.m2.tiila.fitmarket.mapper.ClasseMapper;
import com.m2.tiila.fitmarket.mapper.CommentMapper;
import dto.fitmarketapi.*;
import jakarta.inject.Inject;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Component;

import java.sql.Array;
import java.util.*;

@Component
public class CommentRepository {
    private final static String SQL_GET_COMMENTS_PRODUCT = "SELECT c.id AS comment_id, c.content, c.date_time, c.note, c.title, " +
            "m.id AS user_id, m.firstname AS user_firstname, m.lastname AS user_lastname, m.email AS user_email, " +
            "GROUP_CONCAT(ic.image) AS images " +
            "FROM comment c " +
            "LEFT JOIN member m ON c.id_user = m.id " +
            "LEFT JOIN image_comment ic ON c.id = ic.id_comment " +
            "WHERE c.id_product = :productId " +
            "GROUP BY c.id";


    private final static String SQL_GET_BEST_COMMENTS = "SELECT c.id AS comment_id, c.content, c.date_time, c.note, c.title, " +
            "m.id AS user_id, m.firstname AS user_firstname, m.lastname AS user_lastname, m.email AS user_email, " +
            "p.id AS product_id, p.title AS product_title, p.price AS product_price, p.description AS product_description, p.category AS product_category, " +
            "GROUP_CONCAT(ic.image) AS images " +
            "FROM comment c " +
            "LEFT JOIN member m ON c.id_user = m.id " +
            "LEFT JOIN image_comment ic ON c.id = ic.id_comment " +
            "LEFT JOIN product p ON c.id_product = p.id " +
            "GROUP BY c.id " +
            "ORDER BY c.note DESC;";

    private final static String SQL_CREATE_COMMENT = "INSERT INTO COMMENT (title, content, date_time, note, id_user, id_product) VALUES (:title, :content, :dateTime, :note, :user, :product)";

    private final static String SQL_INSERT_COMMENT_IMAGE = "INSERT INTO image_comment (id_comment, image) VALUES (:id, :image)";

    @Inject
    private NamedParameterJdbcTemplate jdbcTemplate;

    public List<CommentEntity> getCommentsByProduct(Integer idProduct) {
        MapSqlParameterSource params = new MapSqlParameterSource().addValue("productId", idProduct);

        List<Comment> comments = jdbcTemplate.query(SQL_GET_COMMENTS_PRODUCT, params, (resultSet, rowNum) -> {
            Comment comment = new Comment();
            comment.setId(resultSet.getInt("comment_id"));
            comment.setContent(resultSet.getString("content"));
            comment.setDateTime(resultSet.getString("date_time"));
            comment.setNote(resultSet.getInt("note"));
            comment.setTitle(resultSet.getString("title"));

            Member user = new Member();
            user.setId(resultSet.getInt("user_id"));
            user.setFirstname(resultSet.getString("user_firstname"));
            user.setLastname(resultSet.getString("user_lastname"));
            user.setEmail(resultSet.getString("user_email"));
            comment.setUser(user);

            String imagesConcatenated = resultSet.getString("images");
            if (imagesConcatenated != null) {
                List<String> images = Arrays.asList(imagesConcatenated.split(","));
                comment.setImages(images);
            } else {
                comment.setImages(Collections.emptyList());
            }

            return comment;
        });
        return comments.stream().map(CommentMapper::toEntity).toList();
    }

    public List<CommentEntity> getBestComments() {

        List<Comment> comments = jdbcTemplate.query(SQL_GET_BEST_COMMENTS,(resultSet, rowNum) -> {
            Comment comment = new Comment();
            comment.setId(resultSet.getInt("comment_id"));
            comment.setContent(resultSet.getString("content"));
            comment.setDateTime(resultSet.getString("date_time"));
            comment.setNote(resultSet.getInt("note"));
            comment.setTitle(resultSet.getString("title"));

            Member user = new Member();
            user.setId(resultSet.getInt("user_id"));
            user.setFirstname(resultSet.getString("user_firstname"));
            user.setLastname(resultSet.getString("user_lastname"));
            user.setEmail(resultSet.getString("user_email"));
            comment.setUser(user);

            Product product = new Product();
            product.setId(resultSet.getInt("product_id"));
            product.setTitle(resultSet.getString("product_title"));
            product.setPrice(resultSet.getInt("product_price"));
            product.setDescription(resultSet.getString("product_description"));
            product.setCategory(Category.fromValue(resultSet.getString("product_category")));
            comment.setProduct(product);

            String imagesConcatenated = resultSet.getString("images");
            if (imagesConcatenated != null) {
                List<String> images = Arrays.asList(imagesConcatenated.split(","));
                comment.setImages(images);
            } else {
                comment.setImages(Collections.emptyList());
            }

            return comment;
        });
        return comments.stream().map(CommentMapper::toEntity).toList();
    }

    public void createComment(Comment dto) {
        var params = new HashMap<String, Object>();
        params.put("content",dto.getContent());
        params.put("dateTime",dto.getDateTime());
        params.put("note",dto.getNote());
        params.put("product",dto.getProduct().getId());
        params.put("user",dto.getUser().getId());
        params.put("title",dto.getTitle());

        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();

        this.jdbcTemplate.update(SQL_CREATE_COMMENT, new MapSqlParameterSource(params), generatedKeyHolder);
        var paramComment = new HashMap<String, Object>();
        Integer id = (Integer) generatedKeyHolder.getKeys().get("ID");
        paramComment.put("id",id);

        for(String i : dto.getImages()){
            paramComment.put("image",i);
            this.jdbcTemplate.update(SQL_INSERT_COMMENT_IMAGE, paramComment);
        }
    }

}