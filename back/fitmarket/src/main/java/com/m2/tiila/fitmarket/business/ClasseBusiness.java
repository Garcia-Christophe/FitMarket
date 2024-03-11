package com.m2.tiila.fitmarket.business;

import com.m2.tiila.fitmarket.entity.ClasseEntity;
import com.m2.tiila.fitmarket.mapper.ClasseMapper;
import com.m2.tiila.fitmarket.repository.ClasseRepository;
import com.m2.tiila.fitmarket.repository.ProductRepository;
import dto.fitmarketapi.Classes;
import dto.fitmarketapi.Product;
import jakarta.inject.Inject;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.m2.tiila.fitmarket.mapper.ClasseMapper.toDto;
import static com.m2.tiila.fitmarket.mapper.ProductMapper.toDto;

@Component
public class ClasseBusiness {
    @Inject
    private ClasseRepository classeRepository;

    @Inject
    private ProductRepository productRepository;

    public Classes getClasse(int id) {
        ClasseEntity c = this.classeRepository.getClasse(id);
        return toDto(c);
    }

    public List<Classes> getClassesByUserId(int id){
        List<ClasseEntity> classesEntity = this.classeRepository.getClassesByUserId(id);
        return classesEntity.stream().map(ClasseMapper::toDto).toList();
    }
}
