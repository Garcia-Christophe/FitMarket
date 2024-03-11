package com.m2.tiila.fitmarket.business;

import com.m2.tiila.fitmarket.entity.MemberEntity;
import com.m2.tiila.fitmarket.repository.UserRepository;
import dto.fitmarketapi.Member;
import jakarta.inject.Inject;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.m2.tiila.fitmarket.mapper.UserMapper.toDto;

@Component
public class UserBusiness {
    @Inject
    private UserRepository userRepository;

    public Member signIn(String email, String password) {
        return  toDto(userRepository.signIn(email, password));
    }

    public void signUp(MemberEntity member) {
      userRepository.signUp(toDto(member));
    }
    public void updateMember(int id, MemberEntity member) {
        userRepository.updateMember(id,toDto(member));
    }
}
