package com.m2.tiila.fitmarket.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberEntity {
    private Integer id;
    private String lastname;
    private String firstname;
    private String email;
    private String password;
}
