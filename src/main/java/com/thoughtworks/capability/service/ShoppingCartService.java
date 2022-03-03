package com.thoughtworks.capability.service;

import com.thoughtworks.capability.infrastructure.ShoppingCartRepository;
import com.thoughtworks.capability.web.dto.ShoppingCartResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@AllArgsConstructor
public class ShoppingCartService {
    private ShoppingCartRepository shoppingCartRepository;
    public ShoppingCartResponse findShoppingCart() {
        return new ShoppingCartResponse(shoppingCartRepository.findAll(), BigDecimal.ZERO);
    }
}
