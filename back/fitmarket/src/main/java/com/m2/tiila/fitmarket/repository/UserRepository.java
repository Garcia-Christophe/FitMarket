package com.m2.tiila.fitmarket.repository;

import com.m2.tiila.fitmarket.entity.ClasseEntity;
import com.m2.tiila.fitmarket.entity.MemberEntity;
import com.m2.tiila.fitmarket.mapper.ClasseMapper;
import com.m2.tiila.fitmarket.mapper.UserMapper;
import dto.fitmarketapi.Classes;
import dto.fitmarketapi.Member;
import jakarta.inject.Inject;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class UserRepository {
    private final static String SQL_GET_USER_BY_EMAIL_AND_PASSWORD = "SELECT m.* FROM member m "+
            "WHERE m.email=:email AND m.password=:password";

    private final static String SQL_GET_USER_BY_ID = "SELECT m.* FROM member m "+
            "WHERE m.id=:id";

    private final static String SQL_CREATE_MEMBER = "INSERT INTO member (lastname, firstname, email, password) " +
            "VALUES (:lastname, :firstname, :email, :password)";

    private final static String SQL_UPDATE_MEMBER = "UPDATE MEMBER SET lastname = :lastname, firstname = :firstname, email= :email, password = :password WHERE id = :id";


    @Inject
    private NamedParameterJdbcTemplate jdbcTemplate;

    public MemberEntity signIn(String email, String password) {
        var params = new HashMap<String, Object>();
        params.put("email", email);
        params.put("password", password);

        List<Member> member = new ArrayList<Member>(this.jdbcTemplate.query(SQL_GET_USER_BY_EMAIL_AND_PASSWORD, params, new BeanPropertyRowMapper<>(Member.class)));
        return member.stream().map(UserMapper::toEntity).toList().get(0);
    }

    public void signUp(Member member) {
        var params = new HashMap<String, Object>();
        params.put("lastname",member.getLastname());
        params.put("firstname",member.getFirstname());
        params.put("email",member.getEmail());
        params.put("password",member.getPassword());

        this.jdbcTemplate.update(SQL_CREATE_MEMBER, params);
    }

    public void updateMember(int id, Member member){
        var params = new HashMap<String,Object>();
        params.put("id",id);
        params.put("lastname",member.getLastname());
        params.put("firstname",member.getFirstname());
        params.put("email",member.getEmail());
        params.put("password",member.getPassword());

        this.jdbcTemplate.update(SQL_UPDATE_MEMBER, params);
    }

    public MemberEntity getUserById(int id) {
        var params = new HashMap<String, Object>();
        params.put("id", id);

        List<Member> member = new ArrayList<Member>(this.jdbcTemplate.query(SQL_GET_USER_BY_ID, params, new BeanPropertyRowMapper<>(Member.class)));
        return member.stream().map(UserMapper::toEntity).toList().get(0);
    }
}