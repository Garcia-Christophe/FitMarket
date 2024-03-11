package com.m2.tiila.fitmarket.business;

import com.m2.tiila.fitmarket.mapper.ProductMapper;
import com.m2.tiila.fitmarket.repository.ProductRepository;
import dto.fitmarketapi.Product;
import jakarta.inject.Inject;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.m2.tiila.fitmarket.mapper.ProductMapper.toDto;

@Component
public class ProductBusiness {
    @Inject
    private ProductRepository productRepository;

    public List<Product> getProducts() {
        return this.productRepository.getProducts().stream().map(ProductMapper::toDto).toList();
    }

    public Product getProduct(int id) {
        return toDto(this.productRepository.getProduct(id));
    }
}
