package com.thoughtworks.capability.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
public class ShoppingCartResponse {
    private List products;
    private BigDecimal totalAmount;
}
