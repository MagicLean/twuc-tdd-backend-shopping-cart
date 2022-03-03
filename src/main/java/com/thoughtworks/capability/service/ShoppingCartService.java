package com.thoughtworks.capability.service;

import com.thoughtworks.capability.infrastructure.ProductRepository;
import com.thoughtworks.capability.web.dto.ShoppingCartResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@AllArgsConstructor
public class ShoppingCartService {
    private ProductRepository productRepository;
    public ShoppingCartResponse findShoppingCart() {
        return new ShoppingCartResponse(productRepository.findAll(), BigDecimal.ZERO);
    }
}
