package com.turkcell.ecommerce.service.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BasketItemList {
    private int productId;
    private int quantity;
}
