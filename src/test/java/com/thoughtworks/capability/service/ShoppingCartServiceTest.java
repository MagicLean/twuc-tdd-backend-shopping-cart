package com.thoughtworks.capability.service;

import com.thoughtworks.capability.infrastructure.ProductRepository;
import com.thoughtworks.capability.web.dto.ShoppingCartResponse;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ShoppingCartServiceTest {
    private ProductRepository productRepository = mock(ProductRepository.class);

    private ShoppingCartService shoppingCartService = new ShoppingCartService(productRepository);
    @Test
    void shouldReturnShoppingCartWhenHasNoProducts() {
        // given
        when(productRepository.findAll()).thenReturn(Lists.emptyList());
        // when
        ShoppingCartResponse shoppingCart = shoppingCartService.findShoppingCart();
        // then
        assertEquals(0,shoppingCart.getProducts().size());
        assertEquals(BigDecimal.ZERO, shoppingCart.getTotalAmount());
    }
}
