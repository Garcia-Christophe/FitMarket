package com.m2.tiila.fitmarket.repository;

import com.m2.tiila.fitmarket.entity.CommentEntity;
import com.m2.tiila.fitmarket.mapper.CommentMapper;
import dto.fitmarketapi.Comment;
import jakarta.inject.Inject;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class CommentRepository {
    private final static String SQL_GET_COMMENTS_PRODUCT = "SELECT c.* , GROUP_CONCAT(ic.image) as images " +
            "FROM comment c " +
            "LEFT JOIN image_comment ic ON c.id = ic.id_comment " +
            "WHERE c.id_product = :id "+
            "GROUP BY c.id";

    private final static String SQL_GET_BEST_COMMENTS = "SELECT c.* , GROUP_CONCAT(ic.image) as images " +
            "FROM comment c " +
            "LEFT JOIN image_comment ic ON c.id = ic.id_comment " +
            "GROUP BY c.id "+
            "ORDER BY c.note DESC";

    private final static String SQL_CREATE_COMMENT = "INSERT INTO COMMENT (title, content, date_time, note, id_user, id_product) VALUES (:title, :content, :dateTime, :note, :user, :product)";

    private final static String SQL_INSERT_COMMENT_IMAGE = "INSERT INTO image_comment (id_comment, image) VALUES (:id, :image)";

    private final static String SQL_GET_ID_MEMBER = "SELECT id_user FROM comment where id = :id";

    private final static String SQL_GET_ID_PRODUCT = "SELECT id_product FROM comment where id = :id";

    @Inject
    private NamedParameterJdbcTemplate jdbcTemplate;

    public List<CommentEntity> getCommentsByProduct(Integer idProduct) {
        var params = new HashMap<String, Object>();
        params.put("id",idProduct);
        List<Comment> comments = new ArrayList<Comment>(this.jdbcTemplate.query(SQL_GET_COMMENTS_PRODUCT, params, new BeanPropertyRowMapper<>(Comment.class)));
        return comments.stream().map(CommentMapper::toEntity).toList();
    }

    public List<CommentEntity> getBestComments() {
        List<Comment> comments = new ArrayList<Comment>(this.jdbcTemplate.query(SQL_GET_BEST_COMMENTS, new BeanPropertyRowMapper<>(Comment.class)));
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

    public int getIdMemberByComment(Integer id) {
        var params = new HashMap<String, Object>();
        params.put("id",id);
        List<Integer> idMember = new ArrayList<Integer>(this.jdbcTemplate.queryForList(SQL_GET_ID_MEMBER, params, Integer.class));
        return idMember.get(0);
    }

    public int getIdProductByComment(Integer id) {
        var params = new HashMap<String, Object>();
        params.put("id",id);
        List<Integer> idProduct = new ArrayList<Integer>(this.jdbcTemplate.queryForList(SQL_GET_ID_PRODUCT, params, Integer.class));
        return idProduct.get(0);
    }
}