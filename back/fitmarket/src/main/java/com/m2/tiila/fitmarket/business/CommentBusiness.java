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
    @Inject
    private ProductRepository productRepository;
    @Inject
    private UserRepository userRepository;

    public List<Comment> getCommentsByProduct(Integer idProduct) {
        List<CommentEntity> res = this.commentRepository.getCommentsByProduct(idProduct);
        List<Comment> resDTO = new ArrayList<>();
        for (CommentEntity ce : res){
            ce.setProduct(getProductByComment(ce));
            ce.setUser(getMemberByComment(ce));
            resDTO.add(toDto(ce));
        }
        return resDTO;
    }

    public List<Comment> getBestComments() {
        List<CommentEntity> res = this.commentRepository.getBestComments();
        List<CommentEntity> cinqPremiers = res.subList(0, Math.min(res.size(), 5));
        List<Comment> resDTO = new ArrayList<>();
        for (CommentEntity ce : cinqPremiers){
            ce.setProduct(getProductByComment(ce));
            ce.setUser(getMemberByComment(ce));
            resDTO.add(toDto(ce));
        }
        return resDTO;
    }

    private Member getMemberByComment(CommentEntity commentEntity){
        int idMember = this.commentRepository.getIdMemberByComment(commentEntity.getId());
        return toDto(userRepository.getUserById(idMember));
    }

    private Product getProductByComment(CommentEntity commentEntity){
        int idProduct = this.commentRepository.getIdProductByComment(commentEntity.getId());
        return toDto(productRepository.getProduct(idProduct));
    }

    public void createComment(CommentEntity commentEntity) {
        commentRepository.createComment(toDto(commentEntity));
    }
}
