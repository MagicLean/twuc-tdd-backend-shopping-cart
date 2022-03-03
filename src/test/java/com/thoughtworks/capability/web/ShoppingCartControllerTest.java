package com.thoughtworks.capability.web;

import com.thoughtworks.capability.WebApplicationTest;
import com.thoughtworks.capability.service.ShoppingCartService;
import com.thoughtworks.capability.web.dto.ShoppingCartResponse;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


public class ShoppingCartControllerTest extends WebApplicationTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private ShoppingCartService shoppingCartService;

    @Test
    void shouldReturnShoppingCartWhenHasNoProducts() throws Exception {
        // given
        when(shoppingCartService.findShoppingCart()).thenReturn(new ShoppingCartResponse(Lists.emptyList(), BigDecimal.ZERO));
        // when
        mvc.perform(MockMvcRequestBuilders.get("/shoppingCart"))
        // then
                .andExpect(jsonPath("$.products").isArray())
                .andExpect(jsonPath("$.totalAmount").value(BigDecimal.ZERO));
    }
}
