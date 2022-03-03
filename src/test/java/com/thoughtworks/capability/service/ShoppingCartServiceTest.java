package com.thoughtworks.capability.service;

import com.thoughtworks.capability.infrastructure.ShoppingCartRepository;
import com.thoughtworks.capability.web.dto.ShoppingCartResponse;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ShoppingCartServiceTest {
    private ShoppingCartRepository shoppingCartRepository = mock(ShoppingCartRepository.class);

    private ShoppingCartService shoppingCartService = new ShoppingCartService(shoppingCartRepository);
    @Test
    void shouldReturnShoppingCartWhenHasNoProducts() {
        // given
        when(shoppingCartRepository.findAll()).thenReturn(Lists.emptyList());
        // when
        ShoppingCartResponse shoppingCart = shoppingCartService.findShoppingCart();
        // then
        assertEquals(0,shoppingCart.getProducts().size());
        assertEquals(BigDecimal.ZERO, shoppingCart.getTotalAmount());
    }
}
