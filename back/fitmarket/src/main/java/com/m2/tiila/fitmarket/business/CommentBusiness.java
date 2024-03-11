package com.m2.tiila.fitmarket.business;

import com.m2.tiila.fitmarket.entity.CommentEntity;
import com.m2.tiila.fitmarket.mapper.CommentMapper;
import com.m2.tiila.fitmarket.repository.CommentRepository;
import com.m2.tiila.fitmarket.repository.ProductRepository;
import com.m2.tiila.fitmarket.repository.UserRepository;
import dto.fitmarketapi.Comment;

import dto.fitmarketapi.Member;
import dto.fitmarketapi.Product;
import jakarta.inject.Inject;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static com.m2.tiila.fitmarket.mapper.CommentMapper.toDto;
import static com.m2.tiila.fitmarket.mapper.ProductMapper.toDto;
import static com.m2.tiila.fitmarket.mapper.UserMapper.toDto;


@Component
public class CommentBusiness {
    @Inject
    private CommentRepository commentRepository;

    public List<Comment> getCommentsByProduct(Integer idProduct) {
        List<CommentEntity> res = this.commentRepository.getCommentsByProduct(idProduct);
        return res.stream().map(CommentMapper::toDto).toList();
    }

    public List<Comment> getBestComments() {
        List<CommentEntity> res = this.commentRepository.getBestComments();
        List<CommentEntity> cinqPremiers = res.subList(0, Math.min(res.size(), 5));
        return cinqPremiers.stream().map(CommentMapper::toDto).toList();
    }

    public void createComment(CommentEntity commentEntity) {
        commentRepository.createComment(toDto(commentEntity));
    }
}
